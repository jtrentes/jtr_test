package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass125;
import big.repositories.criteria.MyClass125Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass125Repository")
public class JPAMyClass125Repository implements MyClass125Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass125> findAll () 
	{
		final String hql = "select e from MyClass125 e order by id";
		TypedQuery<MyClass125> query =
			this.entityManager.createQuery(hql, MyClass125.class);
		return query.getResultList();	
	}

	
	public List<MyClass125> findByCriteria (MyClass125Criteria myClass125Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass125> c = cb.createQuery(MyClass125.class);
		javax.persistence.criteria.Root<MyClass125> emp = c.from(MyClass125.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass125Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass125> q = this.entityManager.createQuery(c);
		
		if (myClass125Criteria.getId()!=null ){
			q.setParameter("id", myClass125Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass125>(q.getResultList());	
	}

	
	public MyClass125 findById (Long id) 
	{
		return this.entityManager.find (MyClass125.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass125 save (MyClass125 myclass125) 
	{
		if (myclass125.getId() != null) {
			return this.entityManager.merge(myclass125);
		} else {
			this.entityManager.persist(myclass125);
			return myclass125;
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
