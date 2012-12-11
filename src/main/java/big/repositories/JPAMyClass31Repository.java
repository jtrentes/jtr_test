package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass31Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass31;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass31Repository")
public class JPAMyClass31Repository implements MyClass31Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass31> findAll () 
	{
		final String hql = "select e from MyClass31 e order by id";
		TypedQuery<MyClass31> query =
			this.entityManager.createQuery(hql, MyClass31.class);
		return query.getResultList();	
	}

	
	public List<MyClass31> findByCriteria (MyClass31Criteria myClass31Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass31> c = cb.createQuery(MyClass31.class);
		javax.persistence.criteria.Root<MyClass31> emp = c.from(MyClass31.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass31Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass31> q = this.entityManager.createQuery(c);
		
		if (myClass31Criteria.getId()!=null ){
			q.setParameter("id", myClass31Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass31>(q.getResultList());	
	}

	
	public MyClass31 findById (Long id) 
	{
		return this.entityManager.find (MyClass31.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass31 save (MyClass31 myclass31) 
	{
		if (myclass31.getId() != null) {
			return this.entityManager.merge(myclass31);
		} else {
			this.entityManager.persist(myclass31);
			return myclass31;
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
