package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass110;
import big.repositories.criteria.MyClass110Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass110Repository")
public class JPAMyClass110Repository implements MyClass110Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass110> findAll () 
	{
		final String hql = "select e from MyClass110 e order by id";
		TypedQuery<MyClass110> query =
			this.entityManager.createQuery(hql, MyClass110.class);
		return query.getResultList();	
	}

	
	public List<MyClass110> findByCriteria (MyClass110Criteria myClass110Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass110> c = cb.createQuery(MyClass110.class);
		javax.persistence.criteria.Root<MyClass110> emp = c.from(MyClass110.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass110Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass110> q = this.entityManager.createQuery(c);
		
		if (myClass110Criteria.getId()!=null ){
			q.setParameter("id", myClass110Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass110>(q.getResultList());	
	}

	
	public MyClass110 findById (Long id) 
	{
		return this.entityManager.find (MyClass110.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass110 save (MyClass110 myclass110) 
	{
		if (myclass110.getId() != null) {
			return this.entityManager.merge(myclass110);
		} else {
			this.entityManager.persist(myclass110);
			return myclass110;
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
