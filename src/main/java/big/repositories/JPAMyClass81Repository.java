package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass81Criteria;
import java.util.List;
import big.domain.MyClass81;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass81Repository")
public class JPAMyClass81Repository implements MyClass81Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass81> findAll () 
	{
		final String hql = "select e from MyClass81 e order by id";
		TypedQuery<MyClass81> query =
			this.entityManager.createQuery(hql, MyClass81.class);
		return query.getResultList();	
	}

	
	public List<MyClass81> findByCriteria (MyClass81Criteria myClass81Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass81> c = cb.createQuery(MyClass81.class);
		javax.persistence.criteria.Root<MyClass81> emp = c.from(MyClass81.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass81Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass81Criteria.getMyclass163()!=null && myClass81Criteria.getMyclass163().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass163> val = cb.parameter(big.domain.MyClass163.class, "myclass163");	
			criteria.add(cb.equal(emp.get("myclass163"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass81> q = this.entityManager.createQuery(c);
		
		if (myClass81Criteria.getId()!=null ){
			q.setParameter("id", myClass81Criteria.getId());
		}
		if (myClass81Criteria.getMyclass163()!=null && myClass81Criteria.getMyclass163().getId() > 0 ){
			q.setParameter("myclass163", myClass81Criteria.getMyclass163());
		}
		    
		return new java.util.ArrayList<MyClass81>(q.getResultList());	
	}

	
	public MyClass81 findById (Long id) 
	{
		return this.entityManager.find (MyClass81.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass81 save (MyClass81 myclass81) 
	{
		if (myclass81.getId() != null) {
			return this.entityManager.merge(myclass81);
		} else {
			this.entityManager.persist(myclass81);
			return myclass81;
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
