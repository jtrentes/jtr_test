package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass63;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass63Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass63Repository")
public class JPAMyClass63Repository implements MyClass63Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass63> findAll () 
	{
		final String hql = "select e from MyClass63 e order by id";
		TypedQuery<MyClass63> query =
			this.entityManager.createQuery(hql, MyClass63.class);
		return query.getResultList();	
	}

	
	public List<MyClass63> findByCriteria (MyClass63Criteria myClass63Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass63> c = cb.createQuery(MyClass63.class);
		javax.persistence.criteria.Root<MyClass63> emp = c.from(MyClass63.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass63Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass63Criteria.getMyclass8()!=null && myClass63Criteria.getMyclass8().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass8> val = cb.parameter(big.domain.MyClass8.class, "myclass8");	
			criteria.add(cb.equal(emp.get("myclass8"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass63> q = this.entityManager.createQuery(c);
		
		if (myClass63Criteria.getId()!=null ){
			q.setParameter("id", myClass63Criteria.getId());
		}
		if (myClass63Criteria.getMyclass8()!=null && myClass63Criteria.getMyclass8().getId() > 0 ){
			q.setParameter("myclass8", myClass63Criteria.getMyclass8());
		}
		    
		return new java.util.ArrayList<MyClass63>(q.getResultList());	
	}

	
	public MyClass63 findById (Long id) 
	{
		return this.entityManager.find (MyClass63.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass63 save (MyClass63 myclass63) 
	{
		if (myclass63.getId() != null) {
			return this.entityManager.merge(myclass63);
		} else {
			this.entityManager.persist(myclass63);
			return myclass63;
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
