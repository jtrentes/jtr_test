package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass87Criteria;
import big.domain.MyClass87;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass87Repository")
public class JPAMyClass87Repository implements MyClass87Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass87> findAll () 
	{
		final String hql = "select e from MyClass87 e order by id";
		TypedQuery<MyClass87> query =
			this.entityManager.createQuery(hql, MyClass87.class);
		return query.getResultList();	
	}

	
	public List<MyClass87> findByCriteria (MyClass87Criteria myClass87Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass87> c = cb.createQuery(MyClass87.class);
		javax.persistence.criteria.Root<MyClass87> emp = c.from(MyClass87.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass87Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass87> q = this.entityManager.createQuery(c);
		
		if (myClass87Criteria.getId()!=null ){
			q.setParameter("id", myClass87Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass87>(q.getResultList());	
	}

	
	public MyClass87 findById (Long id) 
	{
		return this.entityManager.find (MyClass87.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass87 save (MyClass87 myclass87) 
	{
		if (myclass87.getId() != null) {
			return this.entityManager.merge(myclass87);
		} else {
			this.entityManager.persist(myclass87);
			return myclass87;
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
