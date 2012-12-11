package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass16;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass16Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass16Repository")
public class JPAMyClass16Repository implements MyClass16Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass16> findAll () 
	{
		final String hql = "select e from MyClass16 e order by id";
		TypedQuery<MyClass16> query =
			this.entityManager.createQuery(hql, MyClass16.class);
		return query.getResultList();	
	}

	
	public List<MyClass16> findByCriteria (MyClass16Criteria myClass16Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass16> c = cb.createQuery(MyClass16.class);
		javax.persistence.criteria.Root<MyClass16> emp = c.from(MyClass16.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass16Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass16> q = this.entityManager.createQuery(c);
		
		if (myClass16Criteria.getId()!=null ){
			q.setParameter("id", myClass16Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass16>(q.getResultList());	
	}

	
	public MyClass16 findById (Long id) 
	{
		return this.entityManager.find (MyClass16.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass16 save (MyClass16 myclass16) 
	{
		if (myclass16.getId() != null) {
			return this.entityManager.merge(myclass16);
		} else {
			this.entityManager.persist(myclass16);
			return myclass16;
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
