package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass60;
import java.util.List;
import big.repositories.criteria.MyClass60Criteria;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass60Repository")
public class JPAMyClass60Repository implements MyClass60Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass60> findAll () 
	{
		final String hql = "select e from MyClass60 e order by id";
		TypedQuery<MyClass60> query =
			this.entityManager.createQuery(hql, MyClass60.class);
		return query.getResultList();	
	}

	
	public List<MyClass60> findByCriteria (MyClass60Criteria myClass60Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass60> c = cb.createQuery(MyClass60.class);
		javax.persistence.criteria.Root<MyClass60> emp = c.from(MyClass60.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass60Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass60> q = this.entityManager.createQuery(c);
		
		if (myClass60Criteria.getId()!=null ){
			q.setParameter("id", myClass60Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass60>(q.getResultList());	
	}

	
	public MyClass60 findById (Long id) 
	{
		return this.entityManager.find (MyClass60.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass60 save (MyClass60 myclass60) 
	{
		if (myclass60.getId() != null) {
			return this.entityManager.merge(myclass60);
		} else {
			this.entityManager.persist(myclass60);
			return myclass60;
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
