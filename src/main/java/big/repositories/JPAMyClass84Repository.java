package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass84Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass84;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass84Repository")
public class JPAMyClass84Repository implements MyClass84Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass84> findAll () 
	{
		final String hql = "select e from MyClass84 e order by id";
		TypedQuery<MyClass84> query =
			this.entityManager.createQuery(hql, MyClass84.class);
		return query.getResultList();	
	}

	
	public List<MyClass84> findByCriteria (MyClass84Criteria myClass84Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass84> c = cb.createQuery(MyClass84.class);
		javax.persistence.criteria.Root<MyClass84> emp = c.from(MyClass84.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass84Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass84> q = this.entityManager.createQuery(c);
		
		if (myClass84Criteria.getId()!=null ){
			q.setParameter("id", myClass84Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass84>(q.getResultList());	
	}

	
	public MyClass84 findById (Long id) 
	{
		return this.entityManager.find (MyClass84.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass84 save (MyClass84 myclass84) 
	{
		if (myclass84.getId() != null) {
			return this.entityManager.merge(myclass84);
		} else {
			this.entityManager.persist(myclass84);
			return myclass84;
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
