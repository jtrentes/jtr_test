package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass91;
import big.repositories.criteria.MyClass91Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass91Repository")
public class JPAMyClass91Repository implements MyClass91Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass91> findAll () 
	{
		final String hql = "select e from MyClass91 e order by id";
		TypedQuery<MyClass91> query =
			this.entityManager.createQuery(hql, MyClass91.class);
		return query.getResultList();	
	}

	
	public List<MyClass91> findByCriteria (MyClass91Criteria myClass91Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass91> c = cb.createQuery(MyClass91.class);
		javax.persistence.criteria.Root<MyClass91> emp = c.from(MyClass91.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass91Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass91> q = this.entityManager.createQuery(c);
		
		if (myClass91Criteria.getId()!=null ){
			q.setParameter("id", myClass91Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass91>(q.getResultList());	
	}

	
	public MyClass91 findById (Long id) 
	{
		return this.entityManager.find (MyClass91.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass91 save (MyClass91 myclass91) 
	{
		if (myclass91.getId() != null) {
			return this.entityManager.merge(myclass91);
		} else {
			this.entityManager.persist(myclass91);
			return myclass91;
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
