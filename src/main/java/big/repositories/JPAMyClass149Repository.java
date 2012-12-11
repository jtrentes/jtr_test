package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass149;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass149Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass149Repository")
public class JPAMyClass149Repository implements MyClass149Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass149> findAll () 
	{
		final String hql = "select e from MyClass149 e order by id";
		TypedQuery<MyClass149> query =
			this.entityManager.createQuery(hql, MyClass149.class);
		return query.getResultList();	
	}

	
	public List<MyClass149> findByCriteria (MyClass149Criteria myClass149Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass149> c = cb.createQuery(MyClass149.class);
		javax.persistence.criteria.Root<MyClass149> emp = c.from(MyClass149.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass149Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass149> q = this.entityManager.createQuery(c);
		
		if (myClass149Criteria.getId()!=null ){
			q.setParameter("id", myClass149Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass149>(q.getResultList());	
	}

	
	public MyClass149 findById (Long id) 
	{
		return this.entityManager.find (MyClass149.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass149 save (MyClass149 myclass149) 
	{
		if (myclass149.getId() != null) {
			return this.entityManager.merge(myclass149);
		} else {
			this.entityManager.persist(myclass149);
			return myclass149;
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
