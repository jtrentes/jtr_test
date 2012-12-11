package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass41;
import big.repositories.criteria.MyClass41Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass41Repository")
public class JPAMyClass41Repository implements MyClass41Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass41> findAll () 
	{
		final String hql = "select e from MyClass41 e order by id";
		TypedQuery<MyClass41> query =
			this.entityManager.createQuery(hql, MyClass41.class);
		return query.getResultList();	
	}

	
	public List<MyClass41> findByCriteria (MyClass41Criteria myClass41Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass41> c = cb.createQuery(MyClass41.class);
		javax.persistence.criteria.Root<MyClass41> emp = c.from(MyClass41.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass41Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass41> q = this.entityManager.createQuery(c);
		
		if (myClass41Criteria.getId()!=null ){
			q.setParameter("id", myClass41Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass41>(q.getResultList());	
	}

	
	public MyClass41 findById (Long id) 
	{
		return this.entityManager.find (MyClass41.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass41 save (MyClass41 myclass41) 
	{
		if (myclass41.getId() != null) {
			return this.entityManager.merge(myclass41);
		} else {
			this.entityManager.persist(myclass41);
			return myclass41;
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
