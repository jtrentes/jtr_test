package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass117Criteria;
import big.domain.MyClass117;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass117Repository")
public class JPAMyClass117Repository implements MyClass117Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass117> findAll () 
	{
		final String hql = "select e from MyClass117 e order by id";
		TypedQuery<MyClass117> query =
			this.entityManager.createQuery(hql, MyClass117.class);
		return query.getResultList();	
	}

	
	public List<MyClass117> findByCriteria (MyClass117Criteria myClass117Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass117> c = cb.createQuery(MyClass117.class);
		javax.persistence.criteria.Root<MyClass117> emp = c.from(MyClass117.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass117Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass117Criteria.getMyclass58()!=null && myClass117Criteria.getMyclass58().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass58> val = cb.parameter(big.domain.MyClass58.class, "myclass58");	
			criteria.add(cb.equal(emp.get("myclass58"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass117> q = this.entityManager.createQuery(c);
		
		if (myClass117Criteria.getId()!=null ){
			q.setParameter("id", myClass117Criteria.getId());
		}
		if (myClass117Criteria.getMyclass58()!=null && myClass117Criteria.getMyclass58().getId() > 0 ){
			q.setParameter("myclass58", myClass117Criteria.getMyclass58());
		}
		    
		return new java.util.ArrayList<MyClass117>(q.getResultList());	
	}

	
	public MyClass117 findById (Long id) 
	{
		return this.entityManager.find (MyClass117.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass117 save (MyClass117 myclass117) 
	{
		if (myclass117.getId() != null) {
			return this.entityManager.merge(myclass117);
		} else {
			this.entityManager.persist(myclass117);
			return myclass117;
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
