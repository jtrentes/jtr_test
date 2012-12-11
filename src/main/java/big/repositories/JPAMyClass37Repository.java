package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass37;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass37Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass37Repository")
public class JPAMyClass37Repository implements MyClass37Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass37> findAll () 
	{
		final String hql = "select e from MyClass37 e order by id";
		TypedQuery<MyClass37> query =
			this.entityManager.createQuery(hql, MyClass37.class);
		return query.getResultList();	
	}

	
	public List<MyClass37> findByCriteria (MyClass37Criteria myClass37Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass37> c = cb.createQuery(MyClass37.class);
		javax.persistence.criteria.Root<MyClass37> emp = c.from(MyClass37.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass37Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass37Criteria.getMyclass54()!=null && myClass37Criteria.getMyclass54().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass54> val = cb.parameter(big.domain.MyClass54.class, "myclass54");	
			criteria.add(cb.equal(emp.get("myclass54"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass37> q = this.entityManager.createQuery(c);
		
		if (myClass37Criteria.getId()!=null ){
			q.setParameter("id", myClass37Criteria.getId());
		}
		if (myClass37Criteria.getMyclass54()!=null && myClass37Criteria.getMyclass54().getId() > 0 ){
			q.setParameter("myclass54", myClass37Criteria.getMyclass54());
		}
		    
		return new java.util.ArrayList<MyClass37>(q.getResultList());	
	}

	
	public MyClass37 findById (Long id) 
	{
		return this.entityManager.find (MyClass37.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass37 save (MyClass37 myclass37) 
	{
		if (myclass37.getId() != null) {
			return this.entityManager.merge(myclass37);
		} else {
			this.entityManager.persist(myclass37);
			return myclass37;
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
