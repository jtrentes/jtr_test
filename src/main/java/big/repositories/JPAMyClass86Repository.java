package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass86;
import big.repositories.criteria.MyClass86Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass86Repository")
public class JPAMyClass86Repository implements MyClass86Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass86> findAll () 
	{
		final String hql = "select e from MyClass86 e order by id";
		TypedQuery<MyClass86> query =
			this.entityManager.createQuery(hql, MyClass86.class);
		return query.getResultList();	
	}

	
	public List<MyClass86> findByCriteria (MyClass86Criteria myClass86Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass86> c = cb.createQuery(MyClass86.class);
		javax.persistence.criteria.Root<MyClass86> emp = c.from(MyClass86.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass86Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass86> q = this.entityManager.createQuery(c);
		
		if (myClass86Criteria.getId()!=null ){
			q.setParameter("id", myClass86Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass86>(q.getResultList());	
	}

	
	public MyClass86 findById (Long id) 
	{
		return this.entityManager.find (MyClass86.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass86 save (MyClass86 myclass86) 
	{
		if (myclass86.getId() != null) {
			return this.entityManager.merge(myclass86);
		} else {
			this.entityManager.persist(myclass86);
			return myclass86;
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
