package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass96;
import big.repositories.criteria.MyClass96Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass96Repository")
public class JPAMyClass96Repository implements MyClass96Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass96> findAll () 
	{
		final String hql = "select e from MyClass96 e order by id";
		TypedQuery<MyClass96> query =
			this.entityManager.createQuery(hql, MyClass96.class);
		return query.getResultList();	
	}

	
	public List<MyClass96> findByCriteria (MyClass96Criteria myClass96Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass96> c = cb.createQuery(MyClass96.class);
		javax.persistence.criteria.Root<MyClass96> emp = c.from(MyClass96.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass96Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass96> q = this.entityManager.createQuery(c);
		
		if (myClass96Criteria.getId()!=null ){
			q.setParameter("id", myClass96Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass96>(q.getResultList());	
	}

	
	public MyClass96 findById (Long id) 
	{
		return this.entityManager.find (MyClass96.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass96 save (MyClass96 myclass96) 
	{
		if (myclass96.getId() != null) {
			return this.entityManager.merge(myclass96);
		} else {
			this.entityManager.persist(myclass96);
			return myclass96;
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
