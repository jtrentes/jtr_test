package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass70Criteria;
import java.util.List;
import big.domain.MyClass70;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass70Repository")
public class JPAMyClass70Repository implements MyClass70Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass70> findAll () 
	{
		final String hql = "select e from MyClass70 e order by id";
		TypedQuery<MyClass70> query =
			this.entityManager.createQuery(hql, MyClass70.class);
		return query.getResultList();	
	}

	
	public List<MyClass70> findByCriteria (MyClass70Criteria myClass70Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass70> c = cb.createQuery(MyClass70.class);
		javax.persistence.criteria.Root<MyClass70> emp = c.from(MyClass70.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass70Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass70> q = this.entityManager.createQuery(c);
		
		if (myClass70Criteria.getId()!=null ){
			q.setParameter("id", myClass70Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass70>(q.getResultList());	
	}

	
	public MyClass70 findById (Long id) 
	{
		return this.entityManager.find (MyClass70.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass70 save (MyClass70 myclass70) 
	{
		if (myclass70.getId() != null) {
			return this.entityManager.merge(myclass70);
		} else {
			this.entityManager.persist(myclass70);
			return myclass70;
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
