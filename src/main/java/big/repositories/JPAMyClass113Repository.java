package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass113;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass113Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass113Repository")
public class JPAMyClass113Repository implements MyClass113Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass113> findAll () 
	{
		final String hql = "select e from MyClass113 e order by id";
		TypedQuery<MyClass113> query =
			this.entityManager.createQuery(hql, MyClass113.class);
		return query.getResultList();	
	}

	
	public List<MyClass113> findByCriteria (MyClass113Criteria myClass113Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass113> c = cb.createQuery(MyClass113.class);
		javax.persistence.criteria.Root<MyClass113> emp = c.from(MyClass113.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass113Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass113> q = this.entityManager.createQuery(c);
		
		if (myClass113Criteria.getId()!=null ){
			q.setParameter("id", myClass113Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass113>(q.getResultList());	
	}

	
	public MyClass113 findById (Long id) 
	{
		return this.entityManager.find (MyClass113.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass113 save (MyClass113 myclass113) 
	{
		if (myclass113.getId() != null) {
			return this.entityManager.merge(myclass113);
		} else {
			this.entityManager.persist(myclass113);
			return myclass113;
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
