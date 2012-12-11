package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass38Criteria;
import java.util.List;
import big.domain.MyClass38;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass38Repository")
public class JPAMyClass38Repository implements MyClass38Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass38> findAll () 
	{
		final String hql = "select e from MyClass38 e order by id";
		TypedQuery<MyClass38> query =
			this.entityManager.createQuery(hql, MyClass38.class);
		return query.getResultList();	
	}

	
	public List<MyClass38> findByCriteria (MyClass38Criteria myClass38Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass38> c = cb.createQuery(MyClass38.class);
		javax.persistence.criteria.Root<MyClass38> emp = c.from(MyClass38.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass38Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass38> q = this.entityManager.createQuery(c);
		
		if (myClass38Criteria.getId()!=null ){
			q.setParameter("id", myClass38Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass38>(q.getResultList());	
	}

	
	public MyClass38 findById (Long id) 
	{
		return this.entityManager.find (MyClass38.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass38 save (MyClass38 myclass38) 
	{
		if (myclass38.getId() != null) {
			return this.entityManager.merge(myclass38);
		} else {
			this.entityManager.persist(myclass38);
			return myclass38;
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
