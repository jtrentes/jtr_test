package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass103;
import java.util.List;
import big.repositories.criteria.MyClass103Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass103Repository")
public class JPAMyClass103Repository implements MyClass103Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass103> findAll () 
	{
		final String hql = "select e from MyClass103 e order by id";
		TypedQuery<MyClass103> query =
			this.entityManager.createQuery(hql, MyClass103.class);
		return query.getResultList();	
	}

	
	public List<MyClass103> findByCriteria (MyClass103Criteria myClass103Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass103> c = cb.createQuery(MyClass103.class);
		javax.persistence.criteria.Root<MyClass103> emp = c.from(MyClass103.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass103Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass103> q = this.entityManager.createQuery(c);
		
		if (myClass103Criteria.getId()!=null ){
			q.setParameter("id", myClass103Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass103>(q.getResultList());	
	}

	
	public MyClass103 findById (Long id) 
	{
		return this.entityManager.find (MyClass103.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass103 save (MyClass103 myclass103) 
	{
		if (myclass103.getId() != null) {
			return this.entityManager.merge(myclass103);
		} else {
			this.entityManager.persist(myclass103);
			return myclass103;
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
