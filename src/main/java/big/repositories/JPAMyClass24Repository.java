package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass24Criteria;
import big.domain.MyClass24;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass24Repository")
public class JPAMyClass24Repository implements MyClass24Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass24> findAll () 
	{
		final String hql = "select e from MyClass24 e order by id";
		TypedQuery<MyClass24> query =
			this.entityManager.createQuery(hql, MyClass24.class);
		return query.getResultList();	
	}

	
	public List<MyClass24> findByCriteria (MyClass24Criteria myClass24Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass24> c = cb.createQuery(MyClass24.class);
		javax.persistence.criteria.Root<MyClass24> emp = c.from(MyClass24.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass24Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass24Criteria.getMyclass6()!=null && myClass24Criteria.getMyclass6().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass6> val = cb.parameter(big.domain.MyClass6.class, "myclass6");	
			criteria.add(cb.equal(emp.get("myclass6"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass24> q = this.entityManager.createQuery(c);
		
		if (myClass24Criteria.getId()!=null ){
			q.setParameter("id", myClass24Criteria.getId());
		}
		if (myClass24Criteria.getMyclass6()!=null && myClass24Criteria.getMyclass6().getId() > 0 ){
			q.setParameter("myclass6", myClass24Criteria.getMyclass6());
		}
		    
		return new java.util.ArrayList<MyClass24>(q.getResultList());	
	}

	
	public MyClass24 findById (Long id) 
	{
		return this.entityManager.find (MyClass24.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass24 save (MyClass24 myclass24) 
	{
		if (myclass24.getId() != null) {
			return this.entityManager.merge(myclass24);
		} else {
			this.entityManager.persist(myclass24);
			return myclass24;
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
