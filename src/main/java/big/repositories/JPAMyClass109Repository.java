package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass109Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass109;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass109Repository")
public class JPAMyClass109Repository implements MyClass109Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass109> findAll () 
	{
		final String hql = "select e from MyClass109 e order by id";
		TypedQuery<MyClass109> query =
			this.entityManager.createQuery(hql, MyClass109.class);
		return query.getResultList();	
	}

	
	public List<MyClass109> findByCriteria (MyClass109Criteria myClass109Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass109> c = cb.createQuery(MyClass109.class);
		javax.persistence.criteria.Root<MyClass109> emp = c.from(MyClass109.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass109Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass109> q = this.entityManager.createQuery(c);
		
		if (myClass109Criteria.getId()!=null ){
			q.setParameter("id", myClass109Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass109>(q.getResultList());	
	}

	
	public MyClass109 findById (Long id) 
	{
		return this.entityManager.find (MyClass109.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass109 save (MyClass109 myclass109) 
	{
		if (myclass109.getId() != null) {
			return this.entityManager.merge(myclass109);
		} else {
			this.entityManager.persist(myclass109);
			return myclass109;
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
