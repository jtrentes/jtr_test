package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.domain.MyClass68;
import big.repositories.criteria.MyClass68Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass68Repository")
public class JPAMyClass68Repository implements MyClass68Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass68> findAll () 
	{
		final String hql = "select e from MyClass68 e order by id";
		TypedQuery<MyClass68> query =
			this.entityManager.createQuery(hql, MyClass68.class);
		return query.getResultList();	
	}

	
	public List<MyClass68> findByCriteria (MyClass68Criteria myClass68Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass68> c = cb.createQuery(MyClass68.class);
		javax.persistence.criteria.Root<MyClass68> emp = c.from(MyClass68.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass68Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass68> q = this.entityManager.createQuery(c);
		
		if (myClass68Criteria.getId()!=null ){
			q.setParameter("id", myClass68Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass68>(q.getResultList());	
	}

	
	public MyClass68 findById (Long id) 
	{
		return this.entityManager.find (MyClass68.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass68 save (MyClass68 myclass68) 
	{
		if (myclass68.getId() != null) {
			return this.entityManager.merge(myclass68);
		} else {
			this.entityManager.persist(myclass68);
			return myclass68;
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
