package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass94;
import big.repositories.criteria.MyClass94Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass94Repository")
public class JPAMyClass94Repository implements MyClass94Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass94> findAll () 
	{
		final String hql = "select e from MyClass94 e order by id";
		TypedQuery<MyClass94> query =
			this.entityManager.createQuery(hql, MyClass94.class);
		return query.getResultList();	
	}

	
	public List<MyClass94> findByCriteria (MyClass94Criteria myClass94Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass94> c = cb.createQuery(MyClass94.class);
		javax.persistence.criteria.Root<MyClass94> emp = c.from(MyClass94.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass94Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass94> q = this.entityManager.createQuery(c);
		
		if (myClass94Criteria.getId()!=null ){
			q.setParameter("id", myClass94Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass94>(q.getResultList());	
	}

	
	public MyClass94 findById (Long id) 
	{
		return this.entityManager.find (MyClass94.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass94 save (MyClass94 myclass94) 
	{
		if (myclass94.getId() != null) {
			return this.entityManager.merge(myclass94);
		} else {
			this.entityManager.persist(myclass94);
			return myclass94;
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
