package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass73;
import java.util.List;
import big.repositories.criteria.MyClass73Criteria;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass73Repository")
public class JPAMyClass73Repository implements MyClass73Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass73> findAll () 
	{
		final String hql = "select e from MyClass73 e order by id";
		TypedQuery<MyClass73> query =
			this.entityManager.createQuery(hql, MyClass73.class);
		return query.getResultList();	
	}

	
	public List<MyClass73> findByCriteria (MyClass73Criteria myClass73Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass73> c = cb.createQuery(MyClass73.class);
		javax.persistence.criteria.Root<MyClass73> emp = c.from(MyClass73.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass73Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass73> q = this.entityManager.createQuery(c);
		
		if (myClass73Criteria.getId()!=null ){
			q.setParameter("id", myClass73Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass73>(q.getResultList());	
	}

	
	public MyClass73 findById (Long id) 
	{
		return this.entityManager.find (MyClass73.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass73 save (MyClass73 myclass73) 
	{
		if (myclass73.getId() != null) {
			return this.entityManager.merge(myclass73);
		} else {
			this.entityManager.persist(myclass73);
			return myclass73;
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
