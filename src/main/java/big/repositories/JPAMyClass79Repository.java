package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass79;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass79Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass79Repository")
public class JPAMyClass79Repository implements MyClass79Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass79> findAll () 
	{
		final String hql = "select e from MyClass79 e order by id";
		TypedQuery<MyClass79> query =
			this.entityManager.createQuery(hql, MyClass79.class);
		return query.getResultList();	
	}

	
	public List<MyClass79> findByCriteria (MyClass79Criteria myClass79Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass79> c = cb.createQuery(MyClass79.class);
		javax.persistence.criteria.Root<MyClass79> emp = c.from(MyClass79.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass79Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass79> q = this.entityManager.createQuery(c);
		
		if (myClass79Criteria.getId()!=null ){
			q.setParameter("id", myClass79Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass79>(q.getResultList());	
	}

	
	public MyClass79 findById (Long id) 
	{
		return this.entityManager.find (MyClass79.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass79 save (MyClass79 myclass79) 
	{
		if (myclass79.getId() != null) {
			return this.entityManager.merge(myclass79);
		} else {
			this.entityManager.persist(myclass79);
			return myclass79;
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
