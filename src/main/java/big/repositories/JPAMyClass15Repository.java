package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass15Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass15;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass15Repository")
public class JPAMyClass15Repository implements MyClass15Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass15> findAll () 
	{
		final String hql = "select e from MyClass15 e order by id";
		TypedQuery<MyClass15> query =
			this.entityManager.createQuery(hql, MyClass15.class);
		return query.getResultList();	
	}

	
	public List<MyClass15> findByCriteria (MyClass15Criteria myClass15Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass15> c = cb.createQuery(MyClass15.class);
		javax.persistence.criteria.Root<MyClass15> emp = c.from(MyClass15.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass15Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass15> q = this.entityManager.createQuery(c);
		
		if (myClass15Criteria.getId()!=null ){
			q.setParameter("id", myClass15Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass15>(q.getResultList());	
	}

	
	public MyClass15 findById (Long id) 
	{
		return this.entityManager.find (MyClass15.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass15 save (MyClass15 myclass15) 
	{
		if (myclass15.getId() != null) {
			return this.entityManager.merge(myclass15);
		} else {
			this.entityManager.persist(myclass15);
			return myclass15;
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
