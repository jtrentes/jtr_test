package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass75;
import java.util.List;
import big.repositories.criteria.MyClass75Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass75Repository")
public class JPAMyClass75Repository implements MyClass75Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass75> findAll () 
	{
		final String hql = "select e from MyClass75 e order by id";
		TypedQuery<MyClass75> query =
			this.entityManager.createQuery(hql, MyClass75.class);
		return query.getResultList();	
	}

	
	public List<MyClass75> findByCriteria (MyClass75Criteria myClass75Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass75> c = cb.createQuery(MyClass75.class);
		javax.persistence.criteria.Root<MyClass75> emp = c.from(MyClass75.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass75Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass75> q = this.entityManager.createQuery(c);
		
		if (myClass75Criteria.getId()!=null ){
			q.setParameter("id", myClass75Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass75>(q.getResultList());	
	}

	
	public MyClass75 findById (Long id) 
	{
		return this.entityManager.find (MyClass75.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass75 save (MyClass75 myclass75) 
	{
		if (myclass75.getId() != null) {
			return this.entityManager.merge(myclass75);
		} else {
			this.entityManager.persist(myclass75);
			return myclass75;
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
