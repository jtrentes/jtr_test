package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass100;
import big.repositories.criteria.MyClass100Criteria;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass100Repository")
public class JPAMyClass100Repository implements MyClass100Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass100> findAll () 
	{
		final String hql = "select e from MyClass100 e order by id";
		TypedQuery<MyClass100> query =
			this.entityManager.createQuery(hql, MyClass100.class);
		return query.getResultList();	
	}

	
	public List<MyClass100> findByCriteria (MyClass100Criteria myClass100Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass100> c = cb.createQuery(MyClass100.class);
		javax.persistence.criteria.Root<MyClass100> emp = c.from(MyClass100.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass100Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass100> q = this.entityManager.createQuery(c);
		
		if (myClass100Criteria.getId()!=null ){
			q.setParameter("id", myClass100Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass100>(q.getResultList());	
	}

	
	public MyClass100 findById (Long id) 
	{
		return this.entityManager.find (MyClass100.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass100 save (MyClass100 myclass100) 
	{
		if (myclass100.getId() != null) {
			return this.entityManager.merge(myclass100);
		} else {
			this.entityManager.persist(myclass100);
			return myclass100;
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
