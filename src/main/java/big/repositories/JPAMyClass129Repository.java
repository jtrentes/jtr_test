package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass129Criteria;
import big.domain.MyClass129;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass129Repository")
public class JPAMyClass129Repository implements MyClass129Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass129> findAll () 
	{
		final String hql = "select e from MyClass129 e order by id";
		TypedQuery<MyClass129> query =
			this.entityManager.createQuery(hql, MyClass129.class);
		return query.getResultList();	
	}

	
	public List<MyClass129> findByCriteria (MyClass129Criteria myClass129Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass129> c = cb.createQuery(MyClass129.class);
		javax.persistence.criteria.Root<MyClass129> emp = c.from(MyClass129.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass129Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass129> q = this.entityManager.createQuery(c);
		
		if (myClass129Criteria.getId()!=null ){
			q.setParameter("id", myClass129Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass129>(q.getResultList());	
	}

	
	public MyClass129 findById (Long id) 
	{
		return this.entityManager.find (MyClass129.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass129 save (MyClass129 myclass129) 
	{
		if (myclass129.getId() != null) {
			return this.entityManager.merge(myclass129);
		} else {
			this.entityManager.persist(myclass129);
			return myclass129;
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
