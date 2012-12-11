package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass51;
import big.repositories.criteria.MyClass51Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass51Repository")
public class JPAMyClass51Repository implements MyClass51Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass51> findAll () 
	{
		final String hql = "select e from MyClass51 e order by id";
		TypedQuery<MyClass51> query =
			this.entityManager.createQuery(hql, MyClass51.class);
		return query.getResultList();	
	}

	
	public List<MyClass51> findByCriteria (MyClass51Criteria myClass51Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass51> c = cb.createQuery(MyClass51.class);
		javax.persistence.criteria.Root<MyClass51> emp = c.from(MyClass51.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass51Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass51Criteria.getMyclass17()!=null && myClass51Criteria.getMyclass17().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass17> val = cb.parameter(big.domain.MyClass17.class, "myclass17");	
			criteria.add(cb.equal(emp.get("myclass17"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass51> q = this.entityManager.createQuery(c);
		
		if (myClass51Criteria.getId()!=null ){
			q.setParameter("id", myClass51Criteria.getId());
		}
		if (myClass51Criteria.getMyclass17()!=null && myClass51Criteria.getMyclass17().getId() > 0 ){
			q.setParameter("myclass17", myClass51Criteria.getMyclass17());
		}
		    
		return new java.util.ArrayList<MyClass51>(q.getResultList());	
	}

	
	public MyClass51 findById (Long id) 
	{
		return this.entityManager.find (MyClass51.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass51 save (MyClass51 myclass51) 
	{
		if (myclass51.getId() != null) {
			return this.entityManager.merge(myclass51);
		} else {
			this.entityManager.persist(myclass51);
			return myclass51;
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
