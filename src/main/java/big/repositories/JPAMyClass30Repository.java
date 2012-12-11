package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass30;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass30Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass30Repository")
public class JPAMyClass30Repository implements MyClass30Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass30> findAll () 
	{
		final String hql = "select e from MyClass30 e order by id";
		TypedQuery<MyClass30> query =
			this.entityManager.createQuery(hql, MyClass30.class);
		return query.getResultList();	
	}

	
	public List<MyClass30> findByCriteria (MyClass30Criteria myClass30Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass30> c = cb.createQuery(MyClass30.class);
		javax.persistence.criteria.Root<MyClass30> emp = c.from(MyClass30.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass30Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass30Criteria.getMyclass31()!=null && myClass30Criteria.getMyclass31().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass31> val = cb.parameter(big.domain.MyClass31.class, "myclass31");	
			criteria.add(cb.equal(emp.get("myclass31"),val));
		}
		if (myClass30Criteria.getMyclass107()!=null && myClass30Criteria.getMyclass107().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass107> val = cb.parameter(big.domain.MyClass107.class, "myclass107");	
			criteria.add(cb.equal(emp.get("myclass107"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass30> q = this.entityManager.createQuery(c);
		
		if (myClass30Criteria.getId()!=null ){
			q.setParameter("id", myClass30Criteria.getId());
		}
		if (myClass30Criteria.getMyclass31()!=null && myClass30Criteria.getMyclass31().getId() > 0 ){
			q.setParameter("myclass31", myClass30Criteria.getMyclass31());
		}
		if (myClass30Criteria.getMyclass107()!=null && myClass30Criteria.getMyclass107().getId() > 0 ){
			q.setParameter("myclass107", myClass30Criteria.getMyclass107());
		}
		    
		return new java.util.ArrayList<MyClass30>(q.getResultList());	
	}

	
	public MyClass30 findById (Long id) 
	{
		return this.entityManager.find (MyClass30.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass30 save (MyClass30 myclass30) 
	{
		if (myclass30.getId() != null) {
			return this.entityManager.merge(myclass30);
		} else {
			this.entityManager.persist(myclass30);
			return myclass30;
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
