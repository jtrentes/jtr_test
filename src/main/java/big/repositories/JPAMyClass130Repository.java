package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass130Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass130;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass130Repository")
public class JPAMyClass130Repository implements MyClass130Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass130> findAll () 
	{
		final String hql = "select e from MyClass130 e order by id";
		TypedQuery<MyClass130> query =
			this.entityManager.createQuery(hql, MyClass130.class);
		return query.getResultList();	
	}

	
	public List<MyClass130> findByCriteria (MyClass130Criteria myClass130Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass130> c = cb.createQuery(MyClass130.class);
		javax.persistence.criteria.Root<MyClass130> emp = c.from(MyClass130.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass130Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass130> q = this.entityManager.createQuery(c);
		
		if (myClass130Criteria.getId()!=null ){
			q.setParameter("id", myClass130Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass130>(q.getResultList());	
	}

	
	public MyClass130 findById (Long id) 
	{
		return this.entityManager.find (MyClass130.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass130 save (MyClass130 myclass130) 
	{
		if (myclass130.getId() != null) {
			return this.entityManager.merge(myclass130);
		} else {
			this.entityManager.persist(myclass130);
			return myclass130;
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
