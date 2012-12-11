package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass105Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass105;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass105Repository")
public class JPAMyClass105Repository implements MyClass105Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass105> findAll () 
	{
		final String hql = "select e from MyClass105 e order by id";
		TypedQuery<MyClass105> query =
			this.entityManager.createQuery(hql, MyClass105.class);
		return query.getResultList();	
	}

	
	public List<MyClass105> findByCriteria (MyClass105Criteria myClass105Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass105> c = cb.createQuery(MyClass105.class);
		javax.persistence.criteria.Root<MyClass105> emp = c.from(MyClass105.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass105Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass105> q = this.entityManager.createQuery(c);
		
		if (myClass105Criteria.getId()!=null ){
			q.setParameter("id", myClass105Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass105>(q.getResultList());	
	}

	
	public MyClass105 findById (Long id) 
	{
		return this.entityManager.find (MyClass105.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass105 save (MyClass105 myclass105) 
	{
		if (myclass105.getId() != null) {
			return this.entityManager.merge(myclass105);
		} else {
			this.entityManager.persist(myclass105);
			return myclass105;
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
