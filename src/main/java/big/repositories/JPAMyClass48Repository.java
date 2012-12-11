package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass48Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass48;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass48Repository")
public class JPAMyClass48Repository implements MyClass48Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass48> findAll () 
	{
		final String hql = "select e from MyClass48 e order by id";
		TypedQuery<MyClass48> query =
			this.entityManager.createQuery(hql, MyClass48.class);
		return query.getResultList();	
	}

	
	public List<MyClass48> findByCriteria (MyClass48Criteria myClass48Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass48> c = cb.createQuery(MyClass48.class);
		javax.persistence.criteria.Root<MyClass48> emp = c.from(MyClass48.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass48Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass48> q = this.entityManager.createQuery(c);
		
		if (myClass48Criteria.getId()!=null ){
			q.setParameter("id", myClass48Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass48>(q.getResultList());	
	}

	
	public MyClass48 findById (Long id) 
	{
		return this.entityManager.find (MyClass48.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass48 save (MyClass48 myclass48) 
	{
		if (myclass48.getId() != null) {
			return this.entityManager.merge(myclass48);
		} else {
			this.entityManager.persist(myclass48);
			return myclass48;
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
