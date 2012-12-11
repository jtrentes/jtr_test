package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass99Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass99;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass99Repository")
public class JPAMyClass99Repository implements MyClass99Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass99> findAll () 
	{
		final String hql = "select e from MyClass99 e order by id";
		TypedQuery<MyClass99> query =
			this.entityManager.createQuery(hql, MyClass99.class);
		return query.getResultList();	
	}

	
	public List<MyClass99> findByCriteria (MyClass99Criteria myClass99Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass99> c = cb.createQuery(MyClass99.class);
		javax.persistence.criteria.Root<MyClass99> emp = c.from(MyClass99.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass99Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass99> q = this.entityManager.createQuery(c);
		
		if (myClass99Criteria.getId()!=null ){
			q.setParameter("id", myClass99Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass99>(q.getResultList());	
	}

	
	public MyClass99 findById (Long id) 
	{
		return this.entityManager.find (MyClass99.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass99 save (MyClass99 myclass99) 
	{
		if (myclass99.getId() != null) {
			return this.entityManager.merge(myclass99);
		} else {
			this.entityManager.persist(myclass99);
			return myclass99;
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
