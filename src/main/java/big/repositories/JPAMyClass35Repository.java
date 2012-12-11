package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass35Criteria;
import big.domain.MyClass35;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass35Repository")
public class JPAMyClass35Repository implements MyClass35Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass35> findAll () 
	{
		final String hql = "select e from MyClass35 e order by id";
		TypedQuery<MyClass35> query =
			this.entityManager.createQuery(hql, MyClass35.class);
		return query.getResultList();	
	}

	
	public List<MyClass35> findByCriteria (MyClass35Criteria myClass35Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass35> c = cb.createQuery(MyClass35.class);
		javax.persistence.criteria.Root<MyClass35> emp = c.from(MyClass35.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass35Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass35Criteria.getMyclass51()!=null && myClass35Criteria.getMyclass51().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass51> val = cb.parameter(big.domain.MyClass51.class, "myclass51");	
			criteria.add(cb.equal(emp.get("myclass51"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass35> q = this.entityManager.createQuery(c);
		
		if (myClass35Criteria.getId()!=null ){
			q.setParameter("id", myClass35Criteria.getId());
		}
		if (myClass35Criteria.getMyclass51()!=null && myClass35Criteria.getMyclass51().getId() > 0 ){
			q.setParameter("myclass51", myClass35Criteria.getMyclass51());
		}
		    
		return new java.util.ArrayList<MyClass35>(q.getResultList());	
	}

	
	public MyClass35 findById (Long id) 
	{
		return this.entityManager.find (MyClass35.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass35 save (MyClass35 myclass35) 
	{
		if (myclass35.getId() != null) {
			return this.entityManager.merge(myclass35);
		} else {
			this.entityManager.persist(myclass35);
			return myclass35;
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
