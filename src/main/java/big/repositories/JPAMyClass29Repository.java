package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.domain.MyClass29;
import big.repositories.criteria.MyClass29Criteria;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass29Repository")
public class JPAMyClass29Repository implements MyClass29Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass29> findAll () 
	{
		final String hql = "select e from MyClass29 e order by id";
		TypedQuery<MyClass29> query =
			this.entityManager.createQuery(hql, MyClass29.class);
		return query.getResultList();	
	}

	
	public List<MyClass29> findByCriteria (MyClass29Criteria myClass29Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass29> c = cb.createQuery(MyClass29.class);
		javax.persistence.criteria.Root<MyClass29> emp = c.from(MyClass29.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass29Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass29> q = this.entityManager.createQuery(c);
		
		if (myClass29Criteria.getId()!=null ){
			q.setParameter("id", myClass29Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass29>(q.getResultList());	
	}

	
	public MyClass29 findById (Long id) 
	{
		return this.entityManager.find (MyClass29.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass29 save (MyClass29 myclass29) 
	{
		if (myclass29.getId() != null) {
			return this.entityManager.merge(myclass29);
		} else {
			this.entityManager.persist(myclass29);
			return myclass29;
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
