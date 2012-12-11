package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass54Criteria;
import big.domain.MyClass54;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass54Repository")
public class JPAMyClass54Repository implements MyClass54Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass54> findAll () 
	{
		final String hql = "select e from MyClass54 e order by id";
		TypedQuery<MyClass54> query =
			this.entityManager.createQuery(hql, MyClass54.class);
		return query.getResultList();	
	}

	
	public List<MyClass54> findByCriteria (MyClass54Criteria myClass54Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass54> c = cb.createQuery(MyClass54.class);
		javax.persistence.criteria.Root<MyClass54> emp = c.from(MyClass54.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass54Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass54> q = this.entityManager.createQuery(c);
		
		if (myClass54Criteria.getId()!=null ){
			q.setParameter("id", myClass54Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass54>(q.getResultList());	
	}

	
	public MyClass54 findById (Long id) 
	{
		return this.entityManager.find (MyClass54.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass54 save (MyClass54 myclass54) 
	{
		if (myclass54.getId() != null) {
			return this.entityManager.merge(myclass54);
		} else {
			this.entityManager.persist(myclass54);
			return myclass54;
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
