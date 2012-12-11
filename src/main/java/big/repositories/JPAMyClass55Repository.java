package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass55Criteria;
import big.domain.MyClass55;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass55Repository")
public class JPAMyClass55Repository implements MyClass55Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass55> findAll () 
	{
		final String hql = "select e from MyClass55 e order by id";
		TypedQuery<MyClass55> query =
			this.entityManager.createQuery(hql, MyClass55.class);
		return query.getResultList();	
	}

	
	public List<MyClass55> findByCriteria (MyClass55Criteria myClass55Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass55> c = cb.createQuery(MyClass55.class);
		javax.persistence.criteria.Root<MyClass55> emp = c.from(MyClass55.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass55Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass55> q = this.entityManager.createQuery(c);
		
		if (myClass55Criteria.getId()!=null ){
			q.setParameter("id", myClass55Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass55>(q.getResultList());	
	}

	
	public MyClass55 findById (Long id) 
	{
		return this.entityManager.find (MyClass55.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass55 save (MyClass55 myclass55) 
	{
		if (myclass55.getId() != null) {
			return this.entityManager.merge(myclass55);
		} else {
			this.entityManager.persist(myclass55);
			return myclass55;
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
