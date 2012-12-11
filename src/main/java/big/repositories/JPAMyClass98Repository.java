package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass98;
import big.repositories.criteria.MyClass98Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass98Repository")
public class JPAMyClass98Repository implements MyClass98Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass98> findAll () 
	{
		final String hql = "select e from MyClass98 e order by id";
		TypedQuery<MyClass98> query =
			this.entityManager.createQuery(hql, MyClass98.class);
		return query.getResultList();	
	}

	
	public List<MyClass98> findByCriteria (MyClass98Criteria myClass98Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass98> c = cb.createQuery(MyClass98.class);
		javax.persistence.criteria.Root<MyClass98> emp = c.from(MyClass98.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass98Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass98> q = this.entityManager.createQuery(c);
		
		if (myClass98Criteria.getId()!=null ){
			q.setParameter("id", myClass98Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass98>(q.getResultList());	
	}

	
	public MyClass98 findById (Long id) 
	{
		return this.entityManager.find (MyClass98.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass98 save (MyClass98 myclass98) 
	{
		if (myclass98.getId() != null) {
			return this.entityManager.merge(myclass98);
		} else {
			this.entityManager.persist(myclass98);
			return myclass98;
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
