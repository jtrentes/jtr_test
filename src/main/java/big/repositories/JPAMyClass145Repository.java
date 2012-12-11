package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass145;
import big.repositories.criteria.MyClass145Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass145Repository")
public class JPAMyClass145Repository implements MyClass145Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass145> findAll () 
	{
		final String hql = "select e from MyClass145 e order by id";
		TypedQuery<MyClass145> query =
			this.entityManager.createQuery(hql, MyClass145.class);
		return query.getResultList();	
	}

	
	public List<MyClass145> findByCriteria (MyClass145Criteria myClass145Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass145> c = cb.createQuery(MyClass145.class);
		javax.persistence.criteria.Root<MyClass145> emp = c.from(MyClass145.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass145Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass145> q = this.entityManager.createQuery(c);
		
		if (myClass145Criteria.getId()!=null ){
			q.setParameter("id", myClass145Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass145>(q.getResultList());	
	}

	
	public MyClass145 findById (Long id) 
	{
		return this.entityManager.find (MyClass145.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass145 save (MyClass145 myclass145) 
	{
		if (myclass145.getId() != null) {
			return this.entityManager.merge(myclass145);
		} else {
			this.entityManager.persist(myclass145);
			return myclass145;
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
