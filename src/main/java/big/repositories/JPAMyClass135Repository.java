package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass135Criteria;
import big.domain.MyClass135;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass135Repository")
public class JPAMyClass135Repository implements MyClass135Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass135> findAll () 
	{
		final String hql = "select e from MyClass135 e order by id";
		TypedQuery<MyClass135> query =
			this.entityManager.createQuery(hql, MyClass135.class);
		return query.getResultList();	
	}

	
	public List<MyClass135> findByCriteria (MyClass135Criteria myClass135Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass135> c = cb.createQuery(MyClass135.class);
		javax.persistence.criteria.Root<MyClass135> emp = c.from(MyClass135.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass135Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass135> q = this.entityManager.createQuery(c);
		
		if (myClass135Criteria.getId()!=null ){
			q.setParameter("id", myClass135Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass135>(q.getResultList());	
	}

	
	public MyClass135 findById (Long id) 
	{
		return this.entityManager.find (MyClass135.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass135 save (MyClass135 myclass135) 
	{
		if (myclass135.getId() != null) {
			return this.entityManager.merge(myclass135);
		} else {
			this.entityManager.persist(myclass135);
			return myclass135;
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
