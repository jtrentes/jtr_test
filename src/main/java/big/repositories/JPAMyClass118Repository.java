package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.domain.MyClass118;
import big.repositories.criteria.MyClass118Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass118Repository")
public class JPAMyClass118Repository implements MyClass118Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass118> findAll () 
	{
		final String hql = "select e from MyClass118 e order by id";
		TypedQuery<MyClass118> query =
			this.entityManager.createQuery(hql, MyClass118.class);
		return query.getResultList();	
	}

	
	public List<MyClass118> findByCriteria (MyClass118Criteria myClass118Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass118> c = cb.createQuery(MyClass118.class);
		javax.persistence.criteria.Root<MyClass118> emp = c.from(MyClass118.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass118Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass118> q = this.entityManager.createQuery(c);
		
		if (myClass118Criteria.getId()!=null ){
			q.setParameter("id", myClass118Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass118>(q.getResultList());	
	}

	
	public MyClass118 findById (Long id) 
	{
		return this.entityManager.find (MyClass118.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass118 save (MyClass118 myclass118) 
	{
		if (myclass118.getId() != null) {
			return this.entityManager.merge(myclass118);
		} else {
			this.entityManager.persist(myclass118);
			return myclass118;
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
