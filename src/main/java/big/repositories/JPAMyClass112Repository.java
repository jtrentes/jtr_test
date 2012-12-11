package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass112;
import java.util.List;
import big.repositories.criteria.MyClass112Criteria;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass112Repository")
public class JPAMyClass112Repository implements MyClass112Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass112> findAll () 
	{
		final String hql = "select e from MyClass112 e order by id";
		TypedQuery<MyClass112> query =
			this.entityManager.createQuery(hql, MyClass112.class);
		return query.getResultList();	
	}

	
	public List<MyClass112> findByCriteria (MyClass112Criteria myClass112Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass112> c = cb.createQuery(MyClass112.class);
		javax.persistence.criteria.Root<MyClass112> emp = c.from(MyClass112.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass112Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass112> q = this.entityManager.createQuery(c);
		
		if (myClass112Criteria.getId()!=null ){
			q.setParameter("id", myClass112Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass112>(q.getResultList());	
	}

	
	public MyClass112 findById (Long id) 
	{
		return this.entityManager.find (MyClass112.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass112 save (MyClass112 myclass112) 
	{
		if (myclass112.getId() != null) {
			return this.entityManager.merge(myclass112);
		} else {
			this.entityManager.persist(myclass112);
			return myclass112;
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
