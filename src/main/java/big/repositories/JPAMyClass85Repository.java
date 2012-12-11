package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass85Criteria;
import big.domain.MyClass85;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass85Repository")
public class JPAMyClass85Repository implements MyClass85Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass85> findAll () 
	{
		final String hql = "select e from MyClass85 e order by id";
		TypedQuery<MyClass85> query =
			this.entityManager.createQuery(hql, MyClass85.class);
		return query.getResultList();	
	}

	
	public List<MyClass85> findByCriteria (MyClass85Criteria myClass85Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass85> c = cb.createQuery(MyClass85.class);
		javax.persistence.criteria.Root<MyClass85> emp = c.from(MyClass85.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass85Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass85> q = this.entityManager.createQuery(c);
		
		if (myClass85Criteria.getId()!=null ){
			q.setParameter("id", myClass85Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass85>(q.getResultList());	
	}

	
	public MyClass85 findById (Long id) 
	{
		return this.entityManager.find (MyClass85.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass85 save (MyClass85 myclass85) 
	{
		if (myclass85.getId() != null) {
			return this.entityManager.merge(myclass85);
		} else {
			this.entityManager.persist(myclass85);
			return myclass85;
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
