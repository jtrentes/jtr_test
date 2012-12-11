package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass154Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass154;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass154Repository")
public class JPAMyClass154Repository implements MyClass154Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass154> findAll () 
	{
		final String hql = "select e from MyClass154 e order by id";
		TypedQuery<MyClass154> query =
			this.entityManager.createQuery(hql, MyClass154.class);
		return query.getResultList();	
	}

	
	public List<MyClass154> findByCriteria (MyClass154Criteria myClass154Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass154> c = cb.createQuery(MyClass154.class);
		javax.persistence.criteria.Root<MyClass154> emp = c.from(MyClass154.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass154Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass154> q = this.entityManager.createQuery(c);
		
		if (myClass154Criteria.getId()!=null ){
			q.setParameter("id", myClass154Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass154>(q.getResultList());	
	}

	
	public MyClass154 findById (Long id) 
	{
		return this.entityManager.find (MyClass154.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass154 save (MyClass154 myclass154) 
	{
		if (myclass154.getId() != null) {
			return this.entityManager.merge(myclass154);
		} else {
			this.entityManager.persist(myclass154);
			return myclass154;
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
