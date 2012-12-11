package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass12Criteria;
import big.domain.MyClass12;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass12Repository")
public class JPAMyClass12Repository implements MyClass12Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass12> findAll () 
	{
		final String hql = "select e from MyClass12 e order by id";
		TypedQuery<MyClass12> query =
			this.entityManager.createQuery(hql, MyClass12.class);
		return query.getResultList();	
	}

	
	public List<MyClass12> findByCriteria (MyClass12Criteria myClass12Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass12> c = cb.createQuery(MyClass12.class);
		javax.persistence.criteria.Root<MyClass12> emp = c.from(MyClass12.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass12Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass12> q = this.entityManager.createQuery(c);
		
		if (myClass12Criteria.getId()!=null ){
			q.setParameter("id", myClass12Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass12>(q.getResultList());	
	}

	
	public MyClass12 findById (Long id) 
	{
		return this.entityManager.find (MyClass12.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass12 save (MyClass12 myclass12) 
	{
		if (myclass12.getId() != null) {
			return this.entityManager.merge(myclass12);
		} else {
			this.entityManager.persist(myclass12);
			return myclass12;
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
