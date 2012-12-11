package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass39;
import big.repositories.criteria.MyClass39Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass39Repository")
public class JPAMyClass39Repository implements MyClass39Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass39> findAll () 
	{
		final String hql = "select e from MyClass39 e order by id";
		TypedQuery<MyClass39> query =
			this.entityManager.createQuery(hql, MyClass39.class);
		return query.getResultList();	
	}

	
	public List<MyClass39> findByCriteria (MyClass39Criteria myClass39Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass39> c = cb.createQuery(MyClass39.class);
		javax.persistence.criteria.Root<MyClass39> emp = c.from(MyClass39.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass39Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass39> q = this.entityManager.createQuery(c);
		
		if (myClass39Criteria.getId()!=null ){
			q.setParameter("id", myClass39Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass39>(q.getResultList());	
	}

	
	public MyClass39 findById (Long id) 
	{
		return this.entityManager.find (MyClass39.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass39 save (MyClass39 myclass39) 
	{
		if (myclass39.getId() != null) {
			return this.entityManager.merge(myclass39);
		} else {
			this.entityManager.persist(myclass39);
			return myclass39;
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
