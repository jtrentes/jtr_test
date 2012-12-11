package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass159Criteria;
import big.domain.MyClass159;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass159Repository")
public class JPAMyClass159Repository implements MyClass159Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass159> findAll () 
	{
		final String hql = "select e from MyClass159 e order by id";
		TypedQuery<MyClass159> query =
			this.entityManager.createQuery(hql, MyClass159.class);
		return query.getResultList();	
	}

	
	public List<MyClass159> findByCriteria (MyClass159Criteria myClass159Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass159> c = cb.createQuery(MyClass159.class);
		javax.persistence.criteria.Root<MyClass159> emp = c.from(MyClass159.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass159Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass159> q = this.entityManager.createQuery(c);
		
		if (myClass159Criteria.getId()!=null ){
			q.setParameter("id", myClass159Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass159>(q.getResultList());	
	}

	
	public MyClass159 findById (Long id) 
	{
		return this.entityManager.find (MyClass159.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass159 save (MyClass159 myclass159) 
	{
		if (myclass159.getId() != null) {
			return this.entityManager.merge(myclass159);
		} else {
			this.entityManager.persist(myclass159);
			return myclass159;
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
