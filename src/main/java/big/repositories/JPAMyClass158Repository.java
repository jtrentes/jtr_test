package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass158;
import big.repositories.criteria.MyClass158Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass158Repository")
public class JPAMyClass158Repository implements MyClass158Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass158> findAll () 
	{
		final String hql = "select e from MyClass158 e order by id";
		TypedQuery<MyClass158> query =
			this.entityManager.createQuery(hql, MyClass158.class);
		return query.getResultList();	
	}

	
	public List<MyClass158> findByCriteria (MyClass158Criteria myClass158Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass158> c = cb.createQuery(MyClass158.class);
		javax.persistence.criteria.Root<MyClass158> emp = c.from(MyClass158.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass158Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass158> q = this.entityManager.createQuery(c);
		
		if (myClass158Criteria.getId()!=null ){
			q.setParameter("id", myClass158Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass158>(q.getResultList());	
	}

	
	public MyClass158 findById (Long id) 
	{
		return this.entityManager.find (MyClass158.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass158 save (MyClass158 myclass158) 
	{
		if (myclass158.getId() != null) {
			return this.entityManager.merge(myclass158);
		} else {
			this.entityManager.persist(myclass158);
			return myclass158;
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
