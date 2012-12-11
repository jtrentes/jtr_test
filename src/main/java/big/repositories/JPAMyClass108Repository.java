package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass108;
import big.repositories.criteria.MyClass108Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass108Repository")
public class JPAMyClass108Repository implements MyClass108Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass108> findAll () 
	{
		final String hql = "select e from MyClass108 e order by id";
		TypedQuery<MyClass108> query =
			this.entityManager.createQuery(hql, MyClass108.class);
		return query.getResultList();	
	}

	
	public List<MyClass108> findByCriteria (MyClass108Criteria myClass108Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass108> c = cb.createQuery(MyClass108.class);
		javax.persistence.criteria.Root<MyClass108> emp = c.from(MyClass108.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass108Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass108> q = this.entityManager.createQuery(c);
		
		if (myClass108Criteria.getId()!=null ){
			q.setParameter("id", myClass108Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass108>(q.getResultList());	
	}

	
	public MyClass108 findById (Long id) 
	{
		return this.entityManager.find (MyClass108.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass108 save (MyClass108 myclass108) 
	{
		if (myclass108.getId() != null) {
			return this.entityManager.merge(myclass108);
		} else {
			this.entityManager.persist(myclass108);
			return myclass108;
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
