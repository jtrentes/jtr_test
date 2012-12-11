package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass57;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass57Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass57Repository")
public class JPAMyClass57Repository implements MyClass57Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass57> findAll () 
	{
		final String hql = "select e from MyClass57 e order by id";
		TypedQuery<MyClass57> query =
			this.entityManager.createQuery(hql, MyClass57.class);
		return query.getResultList();	
	}

	
	public List<MyClass57> findByCriteria (MyClass57Criteria myClass57Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass57> c = cb.createQuery(MyClass57.class);
		javax.persistence.criteria.Root<MyClass57> emp = c.from(MyClass57.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass57Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass57Criteria.getMyclass37()!=null && myClass57Criteria.getMyclass37().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass37> val = cb.parameter(big.domain.MyClass37.class, "myclass37");	
			criteria.add(cb.equal(emp.get("myclass37"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass57> q = this.entityManager.createQuery(c);
		
		if (myClass57Criteria.getId()!=null ){
			q.setParameter("id", myClass57Criteria.getId());
		}
		if (myClass57Criteria.getMyclass37()!=null && myClass57Criteria.getMyclass37().getId() > 0 ){
			q.setParameter("myclass37", myClass57Criteria.getMyclass37());
		}
		    
		return new java.util.ArrayList<MyClass57>(q.getResultList());	
	}

	
	public MyClass57 findById (Long id) 
	{
		return this.entityManager.find (MyClass57.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass57 save (MyClass57 myclass57) 
	{
		if (myclass57.getId() != null) {
			return this.entityManager.merge(myclass57);
		} else {
			this.entityManager.persist(myclass57);
			return myclass57;
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
