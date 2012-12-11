package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass122;
import big.repositories.criteria.MyClass122Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass122Repository")
public class JPAMyClass122Repository implements MyClass122Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass122> findAll () 
	{
		final String hql = "select e from MyClass122 e order by id";
		TypedQuery<MyClass122> query =
			this.entityManager.createQuery(hql, MyClass122.class);
		return query.getResultList();	
	}

	
	public List<MyClass122> findByCriteria (MyClass122Criteria myClass122Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass122> c = cb.createQuery(MyClass122.class);
		javax.persistence.criteria.Root<MyClass122> emp = c.from(MyClass122.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass122Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass122> q = this.entityManager.createQuery(c);
		
		if (myClass122Criteria.getId()!=null ){
			q.setParameter("id", myClass122Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass122>(q.getResultList());	
	}

	
	public MyClass122 findById (Long id) 
	{
		return this.entityManager.find (MyClass122.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass122 save (MyClass122 myclass122) 
	{
		if (myclass122.getId() != null) {
			return this.entityManager.merge(myclass122);
		} else {
			this.entityManager.persist(myclass122);
			return myclass122;
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
