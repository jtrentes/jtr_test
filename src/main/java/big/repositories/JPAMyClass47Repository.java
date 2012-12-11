package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.domain.MyClass47;
import big.repositories.criteria.MyClass47Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass47Repository")
public class JPAMyClass47Repository implements MyClass47Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass47> findAll () 
	{
		final String hql = "select e from MyClass47 e order by id";
		TypedQuery<MyClass47> query =
			this.entityManager.createQuery(hql, MyClass47.class);
		return query.getResultList();	
	}

	
	public List<MyClass47> findByCriteria (MyClass47Criteria myClass47Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass47> c = cb.createQuery(MyClass47.class);
		javax.persistence.criteria.Root<MyClass47> emp = c.from(MyClass47.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass47Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass47> q = this.entityManager.createQuery(c);
		
		if (myClass47Criteria.getId()!=null ){
			q.setParameter("id", myClass47Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass47>(q.getResultList());	
	}

	
	public MyClass47 findById (Long id) 
	{
		return this.entityManager.find (MyClass47.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass47 save (MyClass47 myclass47) 
	{
		if (myclass47.getId() != null) {
			return this.entityManager.merge(myclass47);
		} else {
			this.entityManager.persist(myclass47);
			return myclass47;
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
