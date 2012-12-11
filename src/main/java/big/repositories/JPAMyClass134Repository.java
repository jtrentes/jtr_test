package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass134Criteria;
import big.domain.MyClass134;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass134Repository")
public class JPAMyClass134Repository implements MyClass134Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass134> findAll () 
	{
		final String hql = "select e from MyClass134 e order by id";
		TypedQuery<MyClass134> query =
			this.entityManager.createQuery(hql, MyClass134.class);
		return query.getResultList();	
	}

	
	public List<MyClass134> findByCriteria (MyClass134Criteria myClass134Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass134> c = cb.createQuery(MyClass134.class);
		javax.persistence.criteria.Root<MyClass134> emp = c.from(MyClass134.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass134Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass134> q = this.entityManager.createQuery(c);
		
		if (myClass134Criteria.getId()!=null ){
			q.setParameter("id", myClass134Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass134>(q.getResultList());	
	}

	
	public MyClass134 findById (Long id) 
	{
		return this.entityManager.find (MyClass134.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass134 save (MyClass134 myclass134) 
	{
		if (myclass134.getId() != null) {
			return this.entityManager.merge(myclass134);
		} else {
			this.entityManager.persist(myclass134);
			return myclass134;
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
