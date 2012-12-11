package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass144;
import big.repositories.criteria.MyClass144Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass144Repository")
public class JPAMyClass144Repository implements MyClass144Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass144> findAll () 
	{
		final String hql = "select e from MyClass144 e order by id";
		TypedQuery<MyClass144> query =
			this.entityManager.createQuery(hql, MyClass144.class);
		return query.getResultList();	
	}

	
	public List<MyClass144> findByCriteria (MyClass144Criteria myClass144Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass144> c = cb.createQuery(MyClass144.class);
		javax.persistence.criteria.Root<MyClass144> emp = c.from(MyClass144.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass144Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass144> q = this.entityManager.createQuery(c);
		
		if (myClass144Criteria.getId()!=null ){
			q.setParameter("id", myClass144Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass144>(q.getResultList());	
	}

	
	public MyClass144 findById (Long id) 
	{
		return this.entityManager.find (MyClass144.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass144 save (MyClass144 myclass144) 
	{
		if (myclass144.getId() != null) {
			return this.entityManager.merge(myclass144);
		} else {
			this.entityManager.persist(myclass144);
			return myclass144;
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
