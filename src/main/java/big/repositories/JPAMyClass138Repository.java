package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass138Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import big.domain.MyClass138;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass138Repository")
public class JPAMyClass138Repository implements MyClass138Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass138> findAll () 
	{
		final String hql = "select e from MyClass138 e order by id";
		TypedQuery<MyClass138> query =
			this.entityManager.createQuery(hql, MyClass138.class);
		return query.getResultList();	
	}

	
	public List<MyClass138> findByCriteria (MyClass138Criteria myClass138Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass138> c = cb.createQuery(MyClass138.class);
		javax.persistence.criteria.Root<MyClass138> emp = c.from(MyClass138.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass138Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass138> q = this.entityManager.createQuery(c);
		
		if (myClass138Criteria.getId()!=null ){
			q.setParameter("id", myClass138Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass138>(q.getResultList());	
	}

	
	public MyClass138 findById (Long id) 
	{
		return this.entityManager.find (MyClass138.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass138 save (MyClass138 myclass138) 
	{
		if (myclass138.getId() != null) {
			return this.entityManager.merge(myclass138);
		} else {
			this.entityManager.persist(myclass138);
			return myclass138;
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
