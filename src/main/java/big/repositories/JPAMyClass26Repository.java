package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass26Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass26;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass26Repository")
public class JPAMyClass26Repository implements MyClass26Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass26> findAll () 
	{
		final String hql = "select e from MyClass26 e order by id";
		TypedQuery<MyClass26> query =
			this.entityManager.createQuery(hql, MyClass26.class);
		return query.getResultList();	
	}

	
	public List<MyClass26> findByCriteria (MyClass26Criteria myClass26Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass26> c = cb.createQuery(MyClass26.class);
		javax.persistence.criteria.Root<MyClass26> emp = c.from(MyClass26.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass26Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass26> q = this.entityManager.createQuery(c);
		
		if (myClass26Criteria.getId()!=null ){
			q.setParameter("id", myClass26Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass26>(q.getResultList());	
	}

	
	public MyClass26 findById (Long id) 
	{
		return this.entityManager.find (MyClass26.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass26 save (MyClass26 myclass26) 
	{
		if (myclass26.getId() != null) {
			return this.entityManager.merge(myclass26);
		} else {
			this.entityManager.persist(myclass26);
			return myclass26;
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
