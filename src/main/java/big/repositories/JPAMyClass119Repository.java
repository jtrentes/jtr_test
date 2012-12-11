package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass119Criteria;
import big.domain.MyClass119;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass119Repository")
public class JPAMyClass119Repository implements MyClass119Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass119> findAll () 
	{
		final String hql = "select e from MyClass119 e order by id";
		TypedQuery<MyClass119> query =
			this.entityManager.createQuery(hql, MyClass119.class);
		return query.getResultList();	
	}

	
	public List<MyClass119> findByCriteria (MyClass119Criteria myClass119Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass119> c = cb.createQuery(MyClass119.class);
		javax.persistence.criteria.Root<MyClass119> emp = c.from(MyClass119.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass119Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass119> q = this.entityManager.createQuery(c);
		
		if (myClass119Criteria.getId()!=null ){
			q.setParameter("id", myClass119Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass119>(q.getResultList());	
	}

	
	public MyClass119 findById (Long id) 
	{
		return this.entityManager.find (MyClass119.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass119 save (MyClass119 myclass119) 
	{
		if (myclass119.getId() != null) {
			return this.entityManager.merge(myclass119);
		} else {
			this.entityManager.persist(myclass119);
			return myclass119;
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
