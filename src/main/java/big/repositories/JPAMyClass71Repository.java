package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass71Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass71;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass71Repository")
public class JPAMyClass71Repository implements MyClass71Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass71> findAll () 
	{
		final String hql = "select e from MyClass71 e order by id";
		TypedQuery<MyClass71> query =
			this.entityManager.createQuery(hql, MyClass71.class);
		return query.getResultList();	
	}

	
	public List<MyClass71> findByCriteria (MyClass71Criteria myClass71Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass71> c = cb.createQuery(MyClass71.class);
		javax.persistence.criteria.Root<MyClass71> emp = c.from(MyClass71.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass71Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass71Criteria.getMyclass78()!=null && myClass71Criteria.getMyclass78().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass78> val = cb.parameter(big.domain.MyClass78.class, "myclass78");	
			criteria.add(cb.equal(emp.get("myclass78"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass71> q = this.entityManager.createQuery(c);
		
		if (myClass71Criteria.getId()!=null ){
			q.setParameter("id", myClass71Criteria.getId());
		}
		if (myClass71Criteria.getMyclass78()!=null && myClass71Criteria.getMyclass78().getId() > 0 ){
			q.setParameter("myclass78", myClass71Criteria.getMyclass78());
		}
		    
		return new java.util.ArrayList<MyClass71>(q.getResultList());	
	}

	
	public MyClass71 findById (Long id) 
	{
		return this.entityManager.find (MyClass71.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass71 save (MyClass71 myclass71) 
	{
		if (myclass71.getId() != null) {
			return this.entityManager.merge(myclass71);
		} else {
			this.entityManager.persist(myclass71);
			return myclass71;
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
