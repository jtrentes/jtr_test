package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass44;
import big.repositories.criteria.MyClass44Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass44Repository")
public class JPAMyClass44Repository implements MyClass44Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass44> findAll () 
	{
		final String hql = "select e from MyClass44 e order by id";
		TypedQuery<MyClass44> query =
			this.entityManager.createQuery(hql, MyClass44.class);
		return query.getResultList();	
	}

	
	public List<MyClass44> findByCriteria (MyClass44Criteria myClass44Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass44> c = cb.createQuery(MyClass44.class);
		javax.persistence.criteria.Root<MyClass44> emp = c.from(MyClass44.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass44Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass44> q = this.entityManager.createQuery(c);
		
		if (myClass44Criteria.getId()!=null ){
			q.setParameter("id", myClass44Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass44>(q.getResultList());	
	}

	
	public MyClass44 findById (Long id) 
	{
		return this.entityManager.find (MyClass44.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass44 save (MyClass44 myclass44) 
	{
		if (myclass44.getId() != null) {
			return this.entityManager.merge(myclass44);
		} else {
			this.entityManager.persist(myclass44);
			return myclass44;
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
