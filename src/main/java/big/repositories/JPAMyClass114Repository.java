package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.domain.MyClass114;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass114Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass114Repository")
public class JPAMyClass114Repository implements MyClass114Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass114> findAll () 
	{
		final String hql = "select e from MyClass114 e order by id";
		TypedQuery<MyClass114> query =
			this.entityManager.createQuery(hql, MyClass114.class);
		return query.getResultList();	
	}

	
	public List<MyClass114> findByCriteria (MyClass114Criteria myClass114Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass114> c = cb.createQuery(MyClass114.class);
		javax.persistence.criteria.Root<MyClass114> emp = c.from(MyClass114.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass114Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass114> q = this.entityManager.createQuery(c);
		
		if (myClass114Criteria.getId()!=null ){
			q.setParameter("id", myClass114Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass114>(q.getResultList());	
	}

	
	public MyClass114 findById (Long id) 
	{
		return this.entityManager.find (MyClass114.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass114 save (MyClass114 myclass114) 
	{
		if (myclass114.getId() != null) {
			return this.entityManager.merge(myclass114);
		} else {
			this.entityManager.persist(myclass114);
			return myclass114;
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
