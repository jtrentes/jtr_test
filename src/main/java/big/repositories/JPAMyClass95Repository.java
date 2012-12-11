package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass95Criteria;
import big.domain.MyClass95;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass95Repository")
public class JPAMyClass95Repository implements MyClass95Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass95> findAll () 
	{
		final String hql = "select e from MyClass95 e order by id";
		TypedQuery<MyClass95> query =
			this.entityManager.createQuery(hql, MyClass95.class);
		return query.getResultList();	
	}

	
	public List<MyClass95> findByCriteria (MyClass95Criteria myClass95Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass95> c = cb.createQuery(MyClass95.class);
		javax.persistence.criteria.Root<MyClass95> emp = c.from(MyClass95.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass95Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass95> q = this.entityManager.createQuery(c);
		
		if (myClass95Criteria.getId()!=null ){
			q.setParameter("id", myClass95Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass95>(q.getResultList());	
	}

	
	public MyClass95 findById (Long id) 
	{
		return this.entityManager.find (MyClass95.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass95 save (MyClass95 myclass95) 
	{
		if (myclass95.getId() != null) {
			return this.entityManager.merge(myclass95);
		} else {
			this.entityManager.persist(myclass95);
			return myclass95;
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
