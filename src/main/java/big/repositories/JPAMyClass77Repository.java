package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass77;
import java.util.List;
import big.repositories.criteria.MyClass77Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass77Repository")
public class JPAMyClass77Repository implements MyClass77Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass77> findAll () 
	{
		final String hql = "select e from MyClass77 e order by id";
		TypedQuery<MyClass77> query =
			this.entityManager.createQuery(hql, MyClass77.class);
		return query.getResultList();	
	}

	
	public List<MyClass77> findByCriteria (MyClass77Criteria myClass77Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass77> c = cb.createQuery(MyClass77.class);
		javax.persistence.criteria.Root<MyClass77> emp = c.from(MyClass77.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass77Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass77> q = this.entityManager.createQuery(c);
		
		if (myClass77Criteria.getId()!=null ){
			q.setParameter("id", myClass77Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass77>(q.getResultList());	
	}

	
	public MyClass77 findById (Long id) 
	{
		return this.entityManager.find (MyClass77.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass77 save (MyClass77 myclass77) 
	{
		if (myclass77.getId() != null) {
			return this.entityManager.merge(myclass77);
		} else {
			this.entityManager.persist(myclass77);
			return myclass77;
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
