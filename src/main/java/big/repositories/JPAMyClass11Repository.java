package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass11Criteria;
import big.domain.MyClass11;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass11Repository")
public class JPAMyClass11Repository implements MyClass11Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass11> findAll () 
	{
		final String hql = "select e from MyClass11 e order by id";
		TypedQuery<MyClass11> query =
			this.entityManager.createQuery(hql, MyClass11.class);
		return query.getResultList();	
	}

	
	public List<MyClass11> findByCriteria (MyClass11Criteria myClass11Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass11> c = cb.createQuery(MyClass11.class);
		javax.persistence.criteria.Root<MyClass11> emp = c.from(MyClass11.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass11Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass11> q = this.entityManager.createQuery(c);
		
		if (myClass11Criteria.getId()!=null ){
			q.setParameter("id", myClass11Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass11>(q.getResultList());	
	}

	
	public MyClass11 findById (Long id) 
	{
		return this.entityManager.find (MyClass11.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass11 save (MyClass11 myclass11) 
	{
		if (myclass11.getId() != null) {
			return this.entityManager.merge(myclass11);
		} else {
			this.entityManager.persist(myclass11);
			return myclass11;
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
