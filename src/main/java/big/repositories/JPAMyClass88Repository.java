package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass88Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass88;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass88Repository")
public class JPAMyClass88Repository implements MyClass88Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass88> findAll () 
	{
		final String hql = "select e from MyClass88 e order by id";
		TypedQuery<MyClass88> query =
			this.entityManager.createQuery(hql, MyClass88.class);
		return query.getResultList();	
	}

	
	public List<MyClass88> findByCriteria (MyClass88Criteria myClass88Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass88> c = cb.createQuery(MyClass88.class);
		javax.persistence.criteria.Root<MyClass88> emp = c.from(MyClass88.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass88Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass88> q = this.entityManager.createQuery(c);
		
		if (myClass88Criteria.getId()!=null ){
			q.setParameter("id", myClass88Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass88>(q.getResultList());	
	}

	
	public MyClass88 findById (Long id) 
	{
		return this.entityManager.find (MyClass88.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass88 save (MyClass88 myclass88) 
	{
		if (myclass88.getId() != null) {
			return this.entityManager.merge(myclass88);
		} else {
			this.entityManager.persist(myclass88);
			return myclass88;
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
