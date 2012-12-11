package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass151;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass151Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass151Repository")
public class JPAMyClass151Repository implements MyClass151Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass151> findAll () 
	{
		final String hql = "select e from MyClass151 e order by id";
		TypedQuery<MyClass151> query =
			this.entityManager.createQuery(hql, MyClass151.class);
		return query.getResultList();	
	}

	
	public List<MyClass151> findByCriteria (MyClass151Criteria myClass151Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass151> c = cb.createQuery(MyClass151.class);
		javax.persistence.criteria.Root<MyClass151> emp = c.from(MyClass151.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass151Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass151> q = this.entityManager.createQuery(c);
		
		if (myClass151Criteria.getId()!=null ){
			q.setParameter("id", myClass151Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass151>(q.getResultList());	
	}

	
	public MyClass151 findById (Long id) 
	{
		return this.entityManager.find (MyClass151.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass151 save (MyClass151 myclass151) 
	{
		if (myclass151.getId() != null) {
			return this.entityManager.merge(myclass151);
		} else {
			this.entityManager.persist(myclass151);
			return myclass151;
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
