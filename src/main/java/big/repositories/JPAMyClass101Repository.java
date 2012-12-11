package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass101Criteria;
import java.util.List;
import big.domain.MyClass101;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass101Repository")
public class JPAMyClass101Repository implements MyClass101Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass101> findAll () 
	{
		final String hql = "select e from MyClass101 e order by id";
		TypedQuery<MyClass101> query =
			this.entityManager.createQuery(hql, MyClass101.class);
		return query.getResultList();	
	}

	
	public List<MyClass101> findByCriteria (MyClass101Criteria myClass101Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass101> c = cb.createQuery(MyClass101.class);
		javax.persistence.criteria.Root<MyClass101> emp = c.from(MyClass101.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass101Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass101> q = this.entityManager.createQuery(c);
		
		if (myClass101Criteria.getId()!=null ){
			q.setParameter("id", myClass101Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass101>(q.getResultList());	
	}

	
	public MyClass101 findById (Long id) 
	{
		return this.entityManager.find (MyClass101.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass101 save (MyClass101 myclass101) 
	{
		if (myclass101.getId() != null) {
			return this.entityManager.merge(myclass101);
		} else {
			this.entityManager.persist(myclass101);
			return myclass101;
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
