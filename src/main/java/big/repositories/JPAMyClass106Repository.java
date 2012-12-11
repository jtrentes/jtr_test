package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass106Criteria;
import java.util.List;
import big.domain.MyClass106;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass106Repository")
public class JPAMyClass106Repository implements MyClass106Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass106> findAll () 
	{
		final String hql = "select e from MyClass106 e order by id";
		TypedQuery<MyClass106> query =
			this.entityManager.createQuery(hql, MyClass106.class);
		return query.getResultList();	
	}

	
	public List<MyClass106> findByCriteria (MyClass106Criteria myClass106Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass106> c = cb.createQuery(MyClass106.class);
		javax.persistence.criteria.Root<MyClass106> emp = c.from(MyClass106.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass106Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass106> q = this.entityManager.createQuery(c);
		
		if (myClass106Criteria.getId()!=null ){
			q.setParameter("id", myClass106Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass106>(q.getResultList());	
	}

	
	public MyClass106 findById (Long id) 
	{
		return this.entityManager.find (MyClass106.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass106 save (MyClass106 myclass106) 
	{
		if (myclass106.getId() != null) {
			return this.entityManager.merge(myclass106);
		} else {
			this.entityManager.persist(myclass106);
			return myclass106;
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
