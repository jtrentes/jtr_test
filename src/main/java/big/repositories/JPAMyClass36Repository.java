package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass36;
import big.repositories.criteria.MyClass36Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass36Repository")
public class JPAMyClass36Repository implements MyClass36Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass36> findAll () 
	{
		final String hql = "select e from MyClass36 e order by id";
		TypedQuery<MyClass36> query =
			this.entityManager.createQuery(hql, MyClass36.class);
		return query.getResultList();	
	}

	
	public List<MyClass36> findByCriteria (MyClass36Criteria myClass36Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass36> c = cb.createQuery(MyClass36.class);
		javax.persistence.criteria.Root<MyClass36> emp = c.from(MyClass36.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass36Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass36> q = this.entityManager.createQuery(c);
		
		if (myClass36Criteria.getId()!=null ){
			q.setParameter("id", myClass36Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass36>(q.getResultList());	
	}

	
	public MyClass36 findById (Long id) 
	{
		return this.entityManager.find (MyClass36.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass36 save (MyClass36 myclass36) 
	{
		if (myclass36.getId() != null) {
			return this.entityManager.merge(myclass36);
		} else {
			this.entityManager.persist(myclass36);
			return myclass36;
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
