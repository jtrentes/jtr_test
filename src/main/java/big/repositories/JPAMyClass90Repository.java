package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass90Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import big.domain.MyClass90;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass90Repository")
public class JPAMyClass90Repository implements MyClass90Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass90> findAll () 
	{
		final String hql = "select e from MyClass90 e order by id";
		TypedQuery<MyClass90> query =
			this.entityManager.createQuery(hql, MyClass90.class);
		return query.getResultList();	
	}

	
	public List<MyClass90> findByCriteria (MyClass90Criteria myClass90Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass90> c = cb.createQuery(MyClass90.class);
		javax.persistence.criteria.Root<MyClass90> emp = c.from(MyClass90.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass90Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass90> q = this.entityManager.createQuery(c);
		
		if (myClass90Criteria.getId()!=null ){
			q.setParameter("id", myClass90Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass90>(q.getResultList());	
	}

	
	public MyClass90 findById (Long id) 
	{
		return this.entityManager.find (MyClass90.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass90 save (MyClass90 myclass90) 
	{
		if (myclass90.getId() != null) {
			return this.entityManager.merge(myclass90);
		} else {
			this.entityManager.persist(myclass90);
			return myclass90;
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
