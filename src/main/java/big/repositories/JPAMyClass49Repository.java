package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass49Criteria;
import big.domain.MyClass49;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass49Repository")
public class JPAMyClass49Repository implements MyClass49Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass49> findAll () 
	{
		final String hql = "select e from MyClass49 e order by id";
		TypedQuery<MyClass49> query =
			this.entityManager.createQuery(hql, MyClass49.class);
		return query.getResultList();	
	}

	
	public List<MyClass49> findByCriteria (MyClass49Criteria myClass49Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass49> c = cb.createQuery(MyClass49.class);
		javax.persistence.criteria.Root<MyClass49> emp = c.from(MyClass49.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass49Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass49> q = this.entityManager.createQuery(c);
		
		if (myClass49Criteria.getId()!=null ){
			q.setParameter("id", myClass49Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass49>(q.getResultList());	
	}

	
	public MyClass49 findById (Long id) 
	{
		return this.entityManager.find (MyClass49.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass49 save (MyClass49 myclass49) 
	{
		if (myclass49.getId() != null) {
			return this.entityManager.merge(myclass49);
		} else {
			this.entityManager.persist(myclass49);
			return myclass49;
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
