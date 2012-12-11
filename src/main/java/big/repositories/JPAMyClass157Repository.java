package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass157Criteria;
import big.domain.MyClass157;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass157Repository")
public class JPAMyClass157Repository implements MyClass157Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass157> findAll () 
	{
		final String hql = "select e from MyClass157 e order by id";
		TypedQuery<MyClass157> query =
			this.entityManager.createQuery(hql, MyClass157.class);
		return query.getResultList();	
	}

	
	public List<MyClass157> findByCriteria (MyClass157Criteria myClass157Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass157> c = cb.createQuery(MyClass157.class);
		javax.persistence.criteria.Root<MyClass157> emp = c.from(MyClass157.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass157Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass157> q = this.entityManager.createQuery(c);
		
		if (myClass157Criteria.getId()!=null ){
			q.setParameter("id", myClass157Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass157>(q.getResultList());	
	}

	
	public MyClass157 findById (Long id) 
	{
		return this.entityManager.find (MyClass157.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass157 save (MyClass157 myclass157) 
	{
		if (myclass157.getId() != null) {
			return this.entityManager.merge(myclass157);
		} else {
			this.entityManager.persist(myclass157);
			return myclass157;
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
