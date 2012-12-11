package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.domain.MyClass83;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass83Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass83Repository")
public class JPAMyClass83Repository implements MyClass83Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass83> findAll () 
	{
		final String hql = "select e from MyClass83 e order by id";
		TypedQuery<MyClass83> query =
			this.entityManager.createQuery(hql, MyClass83.class);
		return query.getResultList();	
	}

	
	public List<MyClass83> findByCriteria (MyClass83Criteria myClass83Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass83> c = cb.createQuery(MyClass83.class);
		javax.persistence.criteria.Root<MyClass83> emp = c.from(MyClass83.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass83Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass83> q = this.entityManager.createQuery(c);
		
		if (myClass83Criteria.getId()!=null ){
			q.setParameter("id", myClass83Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass83>(q.getResultList());	
	}

	
	public MyClass83 findById (Long id) 
	{
		return this.entityManager.find (MyClass83.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass83 save (MyClass83 myclass83) 
	{
		if (myclass83.getId() != null) {
			return this.entityManager.merge(myclass83);
		} else {
			this.entityManager.persist(myclass83);
			return myclass83;
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
