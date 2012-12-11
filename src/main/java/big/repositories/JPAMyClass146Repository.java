package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass146;
import java.util.List;
import big.repositories.criteria.MyClass146Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass146Repository")
public class JPAMyClass146Repository implements MyClass146Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass146> findAll () 
	{
		final String hql = "select e from MyClass146 e order by id";
		TypedQuery<MyClass146> query =
			this.entityManager.createQuery(hql, MyClass146.class);
		return query.getResultList();	
	}

	
	public List<MyClass146> findByCriteria (MyClass146Criteria myClass146Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass146> c = cb.createQuery(MyClass146.class);
		javax.persistence.criteria.Root<MyClass146> emp = c.from(MyClass146.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass146Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass146> q = this.entityManager.createQuery(c);
		
		if (myClass146Criteria.getId()!=null ){
			q.setParameter("id", myClass146Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass146>(q.getResultList());	
	}

	
	public MyClass146 findById (Long id) 
	{
		return this.entityManager.find (MyClass146.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass146 save (MyClass146 myclass146) 
	{
		if (myclass146.getId() != null) {
			return this.entityManager.merge(myclass146);
		} else {
			this.entityManager.persist(myclass146);
			return myclass146;
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
