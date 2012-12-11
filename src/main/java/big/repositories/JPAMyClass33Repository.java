package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass33Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass33;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass33Repository")
public class JPAMyClass33Repository implements MyClass33Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass33> findAll () 
	{
		final String hql = "select e from MyClass33 e order by id";
		TypedQuery<MyClass33> query =
			this.entityManager.createQuery(hql, MyClass33.class);
		return query.getResultList();	
	}

	
	public List<MyClass33> findByCriteria (MyClass33Criteria myClass33Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass33> c = cb.createQuery(MyClass33.class);
		javax.persistence.criteria.Root<MyClass33> emp = c.from(MyClass33.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass33Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass33> q = this.entityManager.createQuery(c);
		
		if (myClass33Criteria.getId()!=null ){
			q.setParameter("id", myClass33Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass33>(q.getResultList());	
	}

	
	public MyClass33 findById (Long id) 
	{
		return this.entityManager.find (MyClass33.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass33 save (MyClass33 myclass33) 
	{
		if (myclass33.getId() != null) {
			return this.entityManager.merge(myclass33);
		} else {
			this.entityManager.persist(myclass33);
			return myclass33;
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
