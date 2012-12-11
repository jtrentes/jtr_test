package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass143;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass143Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass143Repository")
public class JPAMyClass143Repository implements MyClass143Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass143> findAll () 
	{
		final String hql = "select e from MyClass143 e order by id";
		TypedQuery<MyClass143> query =
			this.entityManager.createQuery(hql, MyClass143.class);
		return query.getResultList();	
	}

	
	public List<MyClass143> findByCriteria (MyClass143Criteria myClass143Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass143> c = cb.createQuery(MyClass143.class);
		javax.persistence.criteria.Root<MyClass143> emp = c.from(MyClass143.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass143Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass143> q = this.entityManager.createQuery(c);
		
		if (myClass143Criteria.getId()!=null ){
			q.setParameter("id", myClass143Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass143>(q.getResultList());	
	}

	
	public MyClass143 findById (Long id) 
	{
		return this.entityManager.find (MyClass143.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass143 save (MyClass143 myclass143) 
	{
		if (myclass143.getId() != null) {
			return this.entityManager.merge(myclass143);
		} else {
			this.entityManager.persist(myclass143);
			return myclass143;
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
