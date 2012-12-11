package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass58Criteria;
import big.domain.MyClass58;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass58Repository")
public class JPAMyClass58Repository implements MyClass58Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass58> findAll () 
	{
		final String hql = "select e from MyClass58 e order by id";
		TypedQuery<MyClass58> query =
			this.entityManager.createQuery(hql, MyClass58.class);
		return query.getResultList();	
	}

	
	public List<MyClass58> findByCriteria (MyClass58Criteria myClass58Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass58> c = cb.createQuery(MyClass58.class);
		javax.persistence.criteria.Root<MyClass58> emp = c.from(MyClass58.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass58Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass58Criteria.getMyclass131()!=null && myClass58Criteria.getMyclass131().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass131> val = cb.parameter(big.domain.MyClass131.class, "myclass131");	
			criteria.add(cb.equal(emp.get("myclass131"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass58> q = this.entityManager.createQuery(c);
		
		if (myClass58Criteria.getId()!=null ){
			q.setParameter("id", myClass58Criteria.getId());
		}
		if (myClass58Criteria.getMyclass131()!=null && myClass58Criteria.getMyclass131().getId() > 0 ){
			q.setParameter("myclass131", myClass58Criteria.getMyclass131());
		}
		    
		return new java.util.ArrayList<MyClass58>(q.getResultList());	
	}

	
	public MyClass58 findById (Long id) 
	{
		return this.entityManager.find (MyClass58.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass58 save (MyClass58 myclass58) 
	{
		if (myclass58.getId() != null) {
			return this.entityManager.merge(myclass58);
		} else {
			this.entityManager.persist(myclass58);
			return myclass58;
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
