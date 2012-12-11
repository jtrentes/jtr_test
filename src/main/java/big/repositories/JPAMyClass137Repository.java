package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.domain.MyClass137;
import big.repositories.criteria.MyClass137Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass137Repository")
public class JPAMyClass137Repository implements MyClass137Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass137> findAll () 
	{
		final String hql = "select e from MyClass137 e order by id";
		TypedQuery<MyClass137> query =
			this.entityManager.createQuery(hql, MyClass137.class);
		return query.getResultList();	
	}

	
	public List<MyClass137> findByCriteria (MyClass137Criteria myClass137Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass137> c = cb.createQuery(MyClass137.class);
		javax.persistence.criteria.Root<MyClass137> emp = c.from(MyClass137.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass137Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass137> q = this.entityManager.createQuery(c);
		
		if (myClass137Criteria.getId()!=null ){
			q.setParameter("id", myClass137Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass137>(q.getResultList());	
	}

	
	public MyClass137 findById (Long id) 
	{
		return this.entityManager.find (MyClass137.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass137 save (MyClass137 myclass137) 
	{
		if (myclass137.getId() != null) {
			return this.entityManager.merge(myclass137);
		} else {
			this.entityManager.persist(myclass137);
			return myclass137;
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
