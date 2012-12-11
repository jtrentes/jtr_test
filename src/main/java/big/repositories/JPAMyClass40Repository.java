package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass40;
import big.repositories.criteria.MyClass40Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass40Repository")
public class JPAMyClass40Repository implements MyClass40Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass40> findAll () 
	{
		final String hql = "select e from MyClass40 e order by id";
		TypedQuery<MyClass40> query =
			this.entityManager.createQuery(hql, MyClass40.class);
		return query.getResultList();	
	}

	
	public List<MyClass40> findByCriteria (MyClass40Criteria myClass40Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass40> c = cb.createQuery(MyClass40.class);
		javax.persistence.criteria.Root<MyClass40> emp = c.from(MyClass40.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass40Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass40> q = this.entityManager.createQuery(c);
		
		if (myClass40Criteria.getId()!=null ){
			q.setParameter("id", myClass40Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass40>(q.getResultList());	
	}

	
	public MyClass40 findById (Long id) 
	{
		return this.entityManager.find (MyClass40.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass40 save (MyClass40 myclass40) 
	{
		if (myclass40.getId() != null) {
			return this.entityManager.merge(myclass40);
		} else {
			this.entityManager.persist(myclass40);
			return myclass40;
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
