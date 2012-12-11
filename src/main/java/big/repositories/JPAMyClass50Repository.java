package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass50;
import big.repositories.criteria.MyClass50Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass50Repository")
public class JPAMyClass50Repository implements MyClass50Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass50> findAll () 
	{
		final String hql = "select e from MyClass50 e order by id";
		TypedQuery<MyClass50> query =
			this.entityManager.createQuery(hql, MyClass50.class);
		return query.getResultList();	
	}

	
	public List<MyClass50> findByCriteria (MyClass50Criteria myClass50Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass50> c = cb.createQuery(MyClass50.class);
		javax.persistence.criteria.Root<MyClass50> emp = c.from(MyClass50.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass50Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass50Criteria.getMyclass139()!=null && myClass50Criteria.getMyclass139().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass139> val = cb.parameter(big.domain.MyClass139.class, "myclass139");	
			criteria.add(cb.equal(emp.get("myclass139"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass50> q = this.entityManager.createQuery(c);
		
		if (myClass50Criteria.getId()!=null ){
			q.setParameter("id", myClass50Criteria.getId());
		}
		if (myClass50Criteria.getMyclass139()!=null && myClass50Criteria.getMyclass139().getId() > 0 ){
			q.setParameter("myclass139", myClass50Criteria.getMyclass139());
		}
		    
		return new java.util.ArrayList<MyClass50>(q.getResultList());	
	}

	
	public MyClass50 findById (Long id) 
	{
		return this.entityManager.find (MyClass50.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass50 save (MyClass50 myclass50) 
	{
		if (myclass50.getId() != null) {
			return this.entityManager.merge(myclass50);
		} else {
			this.entityManager.persist(myclass50);
			return myclass50;
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
