package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass92Criteria;
import big.domain.MyClass92;
import javax.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass92Repository")
public class JPAMyClass92Repository implements MyClass92Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass92> findAll () 
	{
		final String hql = "select e from MyClass92 e order by id";
		TypedQuery<MyClass92> query =
			this.entityManager.createQuery(hql, MyClass92.class);
		return query.getResultList();	
	}

	
	public List<MyClass92> findByCriteria (MyClass92Criteria myClass92Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass92> c = cb.createQuery(MyClass92.class);
		javax.persistence.criteria.Root<MyClass92> emp = c.from(MyClass92.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass92Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass92> q = this.entityManager.createQuery(c);
		
		if (myClass92Criteria.getId()!=null ){
			q.setParameter("id", myClass92Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass92>(q.getResultList());	
	}

	
	public MyClass92 findById (Long id) 
	{
		return this.entityManager.find (MyClass92.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass92 save (MyClass92 myclass92) 
	{
		if (myclass92.getId() != null) {
			return this.entityManager.merge(myclass92);
		} else {
			this.entityManager.persist(myclass92);
			return myclass92;
		}	
	}

	
	public void setEntityManager (EntityManager myEntityManager) 
	{
		this.entityManager = myEntityManager;	
	}

	
	public void unsetEntityManager () 
	{
		this.entityManager = null;	
	}


}
