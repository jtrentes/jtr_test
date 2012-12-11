package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass18Criteria;
import big.domain.MyClass18;
import javax.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass18Repository")
public class JPAMyClass18Repository implements MyClass18Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass18> findAll () 
	{
		final String hql = "select e from MyClass18 e order by id";
		TypedQuery<MyClass18> query =
			this.entityManager.createQuery(hql, MyClass18.class);
		return query.getResultList();	
	}

	
	public List<MyClass18> findByCriteria (MyClass18Criteria myClass18Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass18> c = cb.createQuery(MyClass18.class);
		javax.persistence.criteria.Root<MyClass18> emp = c.from(MyClass18.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass18Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass18Criteria.getMyclass153()!=null && myClass18Criteria.getMyclass153().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass153> val = cb.parameter(big.domain.MyClass153.class, "myclass153");	
			criteria.add(cb.equal(emp.get("myclass153"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass18> q = this.entityManager.createQuery(c);
		
		if (myClass18Criteria.getId()!=null ){
			q.setParameter("id", myClass18Criteria.getId());
		}
		if (myClass18Criteria.getMyclass153()!=null && myClass18Criteria.getMyclass153().getId() > 0 ){
			q.setParameter("myclass153", myClass18Criteria.getMyclass153());
		}
		    
		return new java.util.ArrayList<MyClass18>(q.getResultList());	
	}

	
	public MyClass18 findById (Long id) 
	{
		return this.entityManager.find (MyClass18.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass18 save (MyClass18 myclass18) 
	{
		if (myclass18.getId() != null) {
			return this.entityManager.merge(myclass18);
		} else {
			this.entityManager.persist(myclass18);
			return myclass18;
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
