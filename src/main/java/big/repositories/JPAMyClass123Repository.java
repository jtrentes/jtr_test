package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass123Criteria;
import java.util.List;
import big.domain.MyClass123;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass123Repository")
public class JPAMyClass123Repository implements MyClass123Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass123> findAll () 
	{
		final String hql = "select e from MyClass123 e order by id";
		TypedQuery<MyClass123> query =
			this.entityManager.createQuery(hql, MyClass123.class);
		return query.getResultList();	
	}

	
	public List<MyClass123> findByCriteria (MyClass123Criteria myClass123Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass123> c = cb.createQuery(MyClass123.class);
		javax.persistence.criteria.Root<MyClass123> emp = c.from(MyClass123.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass123Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass123> q = this.entityManager.createQuery(c);
		
		if (myClass123Criteria.getId()!=null ){
			q.setParameter("id", myClass123Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass123>(q.getResultList());	
	}

	
	public MyClass123 findById (Long id) 
	{
		return this.entityManager.find (MyClass123.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass123 save (MyClass123 myclass123) 
	{
		if (myclass123.getId() != null) {
			return this.entityManager.merge(myclass123);
		} else {
			this.entityManager.persist(myclass123);
			return myclass123;
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
