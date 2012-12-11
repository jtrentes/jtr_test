package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass162;
import java.util.List;
import big.repositories.criteria.MyClass162Criteria;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass162Repository")
public class JPAMyClass162Repository implements MyClass162Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass162> findAll () 
	{
		final String hql = "select e from MyClass162 e order by id";
		TypedQuery<MyClass162> query =
			this.entityManager.createQuery(hql, MyClass162.class);
		return query.getResultList();	
	}

	
	public List<MyClass162> findByCriteria (MyClass162Criteria myClass162Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass162> c = cb.createQuery(MyClass162.class);
		javax.persistence.criteria.Root<MyClass162> emp = c.from(MyClass162.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass162Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass162> q = this.entityManager.createQuery(c);
		
		if (myClass162Criteria.getId()!=null ){
			q.setParameter("id", myClass162Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass162>(q.getResultList());	
	}

	
	public MyClass162 findById (Long id) 
	{
		return this.entityManager.find (MyClass162.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass162 save (MyClass162 myclass162) 
	{
		if (myclass162.getId() != null) {
			return this.entityManager.merge(myclass162);
		} else {
			this.entityManager.persist(myclass162);
			return myclass162;
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
