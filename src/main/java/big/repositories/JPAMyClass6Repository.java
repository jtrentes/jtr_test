package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass6;
import big.repositories.criteria.MyClass6Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass6Repository")
public class JPAMyClass6Repository implements MyClass6Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass6> findAll () 
	{
		final String hql = "select e from MyClass6 e order by id";
		TypedQuery<MyClass6> query =
			this.entityManager.createQuery(hql, MyClass6.class);
		return query.getResultList();	
	}

	
	public List<MyClass6> findByCriteria (MyClass6Criteria myClass6Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass6> c = cb.createQuery(MyClass6.class);
		javax.persistence.criteria.Root<MyClass6> emp = c.from(MyClass6.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass6Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass6Criteria.getMyclass12()!=null && myClass6Criteria.getMyclass12().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass12> val = cb.parameter(big.domain.MyClass12.class, "myclass12");	
			criteria.add(cb.equal(emp.get("myclass12"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass6> q = this.entityManager.createQuery(c);
		
		if (myClass6Criteria.getId()!=null ){
			q.setParameter("id", myClass6Criteria.getId());
		}
		if (myClass6Criteria.getMyclass12()!=null && myClass6Criteria.getMyclass12().getId() > 0 ){
			q.setParameter("myclass12", myClass6Criteria.getMyclass12());
		}
		    
		return new java.util.ArrayList<MyClass6>(q.getResultList());	
	}

	
	public MyClass6 findById (Long id) 
	{
		return this.entityManager.find (MyClass6.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass6 save (MyClass6 myclass6) 
	{
		if (myclass6.getId() != null) {
			return this.entityManager.merge(myclass6);
		} else {
			this.entityManager.persist(myclass6);
			return myclass6;
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
