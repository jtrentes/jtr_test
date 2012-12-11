package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass78;
import java.util.List;
import big.repositories.criteria.MyClass78Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass78Repository")
public class JPAMyClass78Repository implements MyClass78Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass78> findAll () 
	{
		final String hql = "select e from MyClass78 e order by id";
		TypedQuery<MyClass78> query =
			this.entityManager.createQuery(hql, MyClass78.class);
		return query.getResultList();	
	}

	
	public List<MyClass78> findByCriteria (MyClass78Criteria myClass78Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass78> c = cb.createQuery(MyClass78.class);
		javax.persistence.criteria.Root<MyClass78> emp = c.from(MyClass78.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass78Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass78Criteria.getMyclass74()!=null && myClass78Criteria.getMyclass74().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass74> val = cb.parameter(big.domain.MyClass74.class, "myclass74");	
			criteria.add(cb.equal(emp.get("myclass74"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass78> q = this.entityManager.createQuery(c);
		
		if (myClass78Criteria.getId()!=null ){
			q.setParameter("id", myClass78Criteria.getId());
		}
		if (myClass78Criteria.getMyclass74()!=null && myClass78Criteria.getMyclass74().getId() > 0 ){
			q.setParameter("myclass74", myClass78Criteria.getMyclass74());
		}
		    
		return new java.util.ArrayList<MyClass78>(q.getResultList());	
	}

	
	public MyClass78 findById (Long id) 
	{
		return this.entityManager.find (MyClass78.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass78 save (MyClass78 myclass78) 
	{
		if (myclass78.getId() != null) {
			return this.entityManager.merge(myclass78);
		} else {
			this.entityManager.persist(myclass78);
			return myclass78;
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
