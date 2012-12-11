package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass140Criteria;
import java.util.List;
import big.domain.MyClass140;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass140Repository")
public class JPAMyClass140Repository implements MyClass140Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass140> findAll () 
	{
		final String hql = "select e from MyClass140 e order by id";
		TypedQuery<MyClass140> query =
			this.entityManager.createQuery(hql, MyClass140.class);
		return query.getResultList();	
	}

	
	public List<MyClass140> findByCriteria (MyClass140Criteria myClass140Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass140> c = cb.createQuery(MyClass140.class);
		javax.persistence.criteria.Root<MyClass140> emp = c.from(MyClass140.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass140Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass140Criteria.getMyclass97()!=null && myClass140Criteria.getMyclass97().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass97> val = cb.parameter(big.domain.MyClass97.class, "myclass97");	
			criteria.add(cb.equal(emp.get("myclass97"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass140> q = this.entityManager.createQuery(c);
		
		if (myClass140Criteria.getId()!=null ){
			q.setParameter("id", myClass140Criteria.getId());
		}
		if (myClass140Criteria.getMyclass97()!=null && myClass140Criteria.getMyclass97().getId() > 0 ){
			q.setParameter("myclass97", myClass140Criteria.getMyclass97());
		}
		    
		return new java.util.ArrayList<MyClass140>(q.getResultList());	
	}

	
	public MyClass140 findById (Long id) 
	{
		return this.entityManager.find (MyClass140.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass140 save (MyClass140 myclass140) 
	{
		if (myclass140.getId() != null) {
			return this.entityManager.merge(myclass140);
		} else {
			this.entityManager.persist(myclass140);
			return myclass140;
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
