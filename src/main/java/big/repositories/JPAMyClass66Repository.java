package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass66Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass66;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass66Repository")
public class JPAMyClass66Repository implements MyClass66Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass66> findAll () 
	{
		final String hql = "select e from MyClass66 e order by id";
		TypedQuery<MyClass66> query =
			this.entityManager.createQuery(hql, MyClass66.class);
		return query.getResultList();	
	}

	
	public List<MyClass66> findByCriteria (MyClass66Criteria myClass66Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass66> c = cb.createQuery(MyClass66.class);
		javax.persistence.criteria.Root<MyClass66> emp = c.from(MyClass66.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass66Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass66> q = this.entityManager.createQuery(c);
		
		if (myClass66Criteria.getId()!=null ){
			q.setParameter("id", myClass66Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass66>(q.getResultList());	
	}

	
	public MyClass66 findById (Long id) 
	{
		return this.entityManager.find (MyClass66.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass66 save (MyClass66 myclass66) 
	{
		if (myclass66.getId() != null) {
			return this.entityManager.merge(myclass66);
		} else {
			this.entityManager.persist(myclass66);
			return myclass66;
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
