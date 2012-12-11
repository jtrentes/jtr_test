package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass147Criteria;
import big.domain.MyClass147;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass147Repository")
public class JPAMyClass147Repository implements MyClass147Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass147> findAll () 
	{
		final String hql = "select e from MyClass147 e order by id";
		TypedQuery<MyClass147> query =
			this.entityManager.createQuery(hql, MyClass147.class);
		return query.getResultList();	
	}

	
	public List<MyClass147> findByCriteria (MyClass147Criteria myClass147Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass147> c = cb.createQuery(MyClass147.class);
		javax.persistence.criteria.Root<MyClass147> emp = c.from(MyClass147.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass147Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass147> q = this.entityManager.createQuery(c);
		
		if (myClass147Criteria.getId()!=null ){
			q.setParameter("id", myClass147Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass147>(q.getResultList());	
	}

	
	public MyClass147 findById (Long id) 
	{
		return this.entityManager.find (MyClass147.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass147 save (MyClass147 myclass147) 
	{
		if (myclass147.getId() != null) {
			return this.entityManager.merge(myclass147);
		} else {
			this.entityManager.persist(myclass147);
			return myclass147;
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
