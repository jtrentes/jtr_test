package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass72;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass72Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass72Repository")
public class JPAMyClass72Repository implements MyClass72Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass72> findAll () 
	{
		final String hql = "select e from MyClass72 e order by id";
		TypedQuery<MyClass72> query =
			this.entityManager.createQuery(hql, MyClass72.class);
		return query.getResultList();	
	}

	
	public List<MyClass72> findByCriteria (MyClass72Criteria myClass72Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass72> c = cb.createQuery(MyClass72.class);
		javax.persistence.criteria.Root<MyClass72> emp = c.from(MyClass72.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass72Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass72> q = this.entityManager.createQuery(c);
		
		if (myClass72Criteria.getId()!=null ){
			q.setParameter("id", myClass72Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass72>(q.getResultList());	
	}

	
	public MyClass72 findById (Long id) 
	{
		return this.entityManager.find (MyClass72.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass72 save (MyClass72 myclass72) 
	{
		if (myclass72.getId() != null) {
			return this.entityManager.merge(myclass72);
		} else {
			this.entityManager.persist(myclass72);
			return myclass72;
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
