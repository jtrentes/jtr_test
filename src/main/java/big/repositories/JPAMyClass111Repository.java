package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass111Criteria;
import big.domain.MyClass111;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass111Repository")
public class JPAMyClass111Repository implements MyClass111Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass111> findAll () 
	{
		final String hql = "select e from MyClass111 e order by id";
		TypedQuery<MyClass111> query =
			this.entityManager.createQuery(hql, MyClass111.class);
		return query.getResultList();	
	}

	
	public List<MyClass111> findByCriteria (MyClass111Criteria myClass111Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass111> c = cb.createQuery(MyClass111.class);
		javax.persistence.criteria.Root<MyClass111> emp = c.from(MyClass111.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass111Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass111Criteria.getMyclass23()!=null && myClass111Criteria.getMyclass23().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass23> val = cb.parameter(big.domain.MyClass23.class, "myclass23");	
			criteria.add(cb.equal(emp.get("myclass23"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass111> q = this.entityManager.createQuery(c);
		
		if (myClass111Criteria.getId()!=null ){
			q.setParameter("id", myClass111Criteria.getId());
		}
		if (myClass111Criteria.getMyclass23()!=null && myClass111Criteria.getMyclass23().getId() > 0 ){
			q.setParameter("myclass23", myClass111Criteria.getMyclass23());
		}
		    
		return new java.util.ArrayList<MyClass111>(q.getResultList());	
	}

	
	public MyClass111 findById (Long id) 
	{
		return this.entityManager.find (MyClass111.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass111 save (MyClass111 myclass111) 
	{
		if (myclass111.getId() != null) {
			return this.entityManager.merge(myclass111);
		} else {
			this.entityManager.persist(myclass111);
			return myclass111;
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
