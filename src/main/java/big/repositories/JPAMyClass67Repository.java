package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass67;
import big.repositories.criteria.MyClass67Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass67Repository")
public class JPAMyClass67Repository implements MyClass67Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass67> findAll () 
	{
		final String hql = "select e from MyClass67 e order by id";
		TypedQuery<MyClass67> query =
			this.entityManager.createQuery(hql, MyClass67.class);
		return query.getResultList();	
	}

	
	public List<MyClass67> findByCriteria (MyClass67Criteria myClass67Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass67> c = cb.createQuery(MyClass67.class);
		javax.persistence.criteria.Root<MyClass67> emp = c.from(MyClass67.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass67Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass67> q = this.entityManager.createQuery(c);
		
		if (myClass67Criteria.getId()!=null ){
			q.setParameter("id", myClass67Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass67>(q.getResultList());	
	}

	
	public MyClass67 findById (Long id) 
	{
		return this.entityManager.find (MyClass67.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass67 save (MyClass67 myclass67) 
	{
		if (myclass67.getId() != null) {
			return this.entityManager.merge(myclass67);
		} else {
			this.entityManager.persist(myclass67);
			return myclass67;
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
