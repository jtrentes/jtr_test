package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass64;
import big.repositories.criteria.MyClass64Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass64Repository")
public class JPAMyClass64Repository implements MyClass64Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass64> findAll () 
	{
		final String hql = "select e from MyClass64 e order by id";
		TypedQuery<MyClass64> query =
			this.entityManager.createQuery(hql, MyClass64.class);
		return query.getResultList();	
	}

	
	public List<MyClass64> findByCriteria (MyClass64Criteria myClass64Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass64> c = cb.createQuery(MyClass64.class);
		javax.persistence.criteria.Root<MyClass64> emp = c.from(MyClass64.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass64Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass64> q = this.entityManager.createQuery(c);
		
		if (myClass64Criteria.getId()!=null ){
			q.setParameter("id", myClass64Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass64>(q.getResultList());	
	}

	
	public MyClass64 findById (Long id) 
	{
		return this.entityManager.find (MyClass64.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass64 save (MyClass64 myclass64) 
	{
		if (myclass64.getId() != null) {
			return this.entityManager.merge(myclass64);
		} else {
			this.entityManager.persist(myclass64);
			return myclass64;
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
