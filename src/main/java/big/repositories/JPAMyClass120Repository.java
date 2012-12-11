package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass120;
import big.repositories.criteria.MyClass120Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass120Repository")
public class JPAMyClass120Repository implements MyClass120Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass120> findAll () 
	{
		final String hql = "select e from MyClass120 e order by id";
		TypedQuery<MyClass120> query =
			this.entityManager.createQuery(hql, MyClass120.class);
		return query.getResultList();	
	}

	
	public List<MyClass120> findByCriteria (MyClass120Criteria myClass120Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass120> c = cb.createQuery(MyClass120.class);
		javax.persistence.criteria.Root<MyClass120> emp = c.from(MyClass120.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass120Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass120Criteria.getMyclass30()!=null && myClass120Criteria.getMyclass30().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass30> val = cb.parameter(big.domain.MyClass30.class, "myclass30");	
			criteria.add(cb.equal(emp.get("myclass30"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass120> q = this.entityManager.createQuery(c);
		
		if (myClass120Criteria.getId()!=null ){
			q.setParameter("id", myClass120Criteria.getId());
		}
		if (myClass120Criteria.getMyclass30()!=null && myClass120Criteria.getMyclass30().getId() > 0 ){
			q.setParameter("myclass30", myClass120Criteria.getMyclass30());
		}
		    
		return new java.util.ArrayList<MyClass120>(q.getResultList());	
	}

	
	public MyClass120 findById (Long id) 
	{
		return this.entityManager.find (MyClass120.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass120 save (MyClass120 myclass120) 
	{
		if (myclass120.getId() != null) {
			return this.entityManager.merge(myclass120);
		} else {
			this.entityManager.persist(myclass120);
			return myclass120;
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
