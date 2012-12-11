package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass121;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass121Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass121Repository")
public class JPAMyClass121Repository implements MyClass121Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass121> findAll () 
	{
		final String hql = "select e from MyClass121 e order by id";
		TypedQuery<MyClass121> query =
			this.entityManager.createQuery(hql, MyClass121.class);
		return query.getResultList();	
	}

	
	public List<MyClass121> findByCriteria (MyClass121Criteria myClass121Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass121> c = cb.createQuery(MyClass121.class);
		javax.persistence.criteria.Root<MyClass121> emp = c.from(MyClass121.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass121Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass121> q = this.entityManager.createQuery(c);
		
		if (myClass121Criteria.getId()!=null ){
			q.setParameter("id", myClass121Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass121>(q.getResultList());	
	}

	
	public MyClass121 findById (Long id) 
	{
		return this.entityManager.find (MyClass121.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass121 save (MyClass121 myclass121) 
	{
		if (myclass121.getId() != null) {
			return this.entityManager.merge(myclass121);
		} else {
			this.entityManager.persist(myclass121);
			return myclass121;
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
