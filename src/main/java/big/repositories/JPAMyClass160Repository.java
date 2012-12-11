package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass160Criteria;
import big.domain.MyClass160;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass160Repository")
public class JPAMyClass160Repository implements MyClass160Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass160> findAll () 
	{
		final String hql = "select e from MyClass160 e order by id";
		TypedQuery<MyClass160> query =
			this.entityManager.createQuery(hql, MyClass160.class);
		return query.getResultList();	
	}

	
	public List<MyClass160> findByCriteria (MyClass160Criteria myClass160Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass160> c = cb.createQuery(MyClass160.class);
		javax.persistence.criteria.Root<MyClass160> emp = c.from(MyClass160.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass160Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass160> q = this.entityManager.createQuery(c);
		
		if (myClass160Criteria.getId()!=null ){
			q.setParameter("id", myClass160Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass160>(q.getResultList());	
	}

	
	public MyClass160 findById (Long id) 
	{
		return this.entityManager.find (MyClass160.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass160 save (MyClass160 myclass160) 
	{
		if (myclass160.getId() != null) {
			return this.entityManager.merge(myclass160);
		} else {
			this.entityManager.persist(myclass160);
			return myclass160;
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
