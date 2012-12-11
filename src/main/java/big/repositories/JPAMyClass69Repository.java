package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass69Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import big.domain.MyClass69;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass69Repository")
public class JPAMyClass69Repository implements MyClass69Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass69> findAll () 
	{
		final String hql = "select e from MyClass69 e order by id";
		TypedQuery<MyClass69> query =
			this.entityManager.createQuery(hql, MyClass69.class);
		return query.getResultList();	
	}

	
	public List<MyClass69> findByCriteria (MyClass69Criteria myClass69Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass69> c = cb.createQuery(MyClass69.class);
		javax.persistence.criteria.Root<MyClass69> emp = c.from(MyClass69.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass69Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass69Criteria.getMyclass70()!=null && myClass69Criteria.getMyclass70().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass70> val = cb.parameter(big.domain.MyClass70.class, "myclass70");	
			criteria.add(cb.equal(emp.get("myclass70"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass69> q = this.entityManager.createQuery(c);
		
		if (myClass69Criteria.getId()!=null ){
			q.setParameter("id", myClass69Criteria.getId());
		}
		if (myClass69Criteria.getMyclass70()!=null && myClass69Criteria.getMyclass70().getId() > 0 ){
			q.setParameter("myclass70", myClass69Criteria.getMyclass70());
		}
		    
		return new java.util.ArrayList<MyClass69>(q.getResultList());	
	}

	
	public MyClass69 findById (Long id) 
	{
		return this.entityManager.find (MyClass69.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass69 save (MyClass69 myclass69) 
	{
		if (myclass69.getId() != null) {
			return this.entityManager.merge(myclass69);
		} else {
			this.entityManager.persist(myclass69);
			return myclass69;
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
