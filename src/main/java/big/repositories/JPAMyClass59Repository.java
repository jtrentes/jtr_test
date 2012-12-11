package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.domain.MyClass59;
import big.repositories.criteria.MyClass59Criteria;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass59Repository")
public class JPAMyClass59Repository implements MyClass59Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass59> findAll () 
	{
		final String hql = "select e from MyClass59 e order by id";
		TypedQuery<MyClass59> query =
			this.entityManager.createQuery(hql, MyClass59.class);
		return query.getResultList();	
	}

	
	public List<MyClass59> findByCriteria (MyClass59Criteria myClass59Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass59> c = cb.createQuery(MyClass59.class);
		javax.persistence.criteria.Root<MyClass59> emp = c.from(MyClass59.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass59Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass59> q = this.entityManager.createQuery(c);
		
		if (myClass59Criteria.getId()!=null ){
			q.setParameter("id", myClass59Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass59>(q.getResultList());	
	}

	
	public MyClass59 findById (Long id) 
	{
		return this.entityManager.find (MyClass59.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass59 save (MyClass59 myclass59) 
	{
		if (myclass59.getId() != null) {
			return this.entityManager.merge(myclass59);
		} else {
			this.entityManager.persist(myclass59);
			return myclass59;
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
