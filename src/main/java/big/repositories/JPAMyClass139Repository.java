package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass139Criteria;
import big.domain.MyClass139;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass139Repository")
public class JPAMyClass139Repository implements MyClass139Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass139> findAll () 
	{
		final String hql = "select e from MyClass139 e order by id";
		TypedQuery<MyClass139> query =
			this.entityManager.createQuery(hql, MyClass139.class);
		return query.getResultList();	
	}

	
	public List<MyClass139> findByCriteria (MyClass139Criteria myClass139Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass139> c = cb.createQuery(MyClass139.class);
		javax.persistence.criteria.Root<MyClass139> emp = c.from(MyClass139.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass139Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass139Criteria.getMyclass131()!=null && myClass139Criteria.getMyclass131().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass131> val = cb.parameter(big.domain.MyClass131.class, "myclass131");	
			criteria.add(cb.equal(emp.get("myclass131"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass139> q = this.entityManager.createQuery(c);
		
		if (myClass139Criteria.getId()!=null ){
			q.setParameter("id", myClass139Criteria.getId());
		}
		if (myClass139Criteria.getMyclass131()!=null && myClass139Criteria.getMyclass131().getId() > 0 ){
			q.setParameter("myclass131", myClass139Criteria.getMyclass131());
		}
		    
		return new java.util.ArrayList<MyClass139>(q.getResultList());	
	}

	
	public MyClass139 findById (Long id) 
	{
		return this.entityManager.find (MyClass139.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass139 save (MyClass139 myclass139) 
	{
		if (myclass139.getId() != null) {
			return this.entityManager.merge(myclass139);
		} else {
			this.entityManager.persist(myclass139);
			return myclass139;
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
