package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.domain.MyClass19;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass19Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass19Repository")
public class JPAMyClass19Repository implements MyClass19Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass19> findAll () 
	{
		final String hql = "select e from MyClass19 e order by id";
		TypedQuery<MyClass19> query =
			this.entityManager.createQuery(hql, MyClass19.class);
		return query.getResultList();	
	}

	
	public List<MyClass19> findByCriteria (MyClass19Criteria myClass19Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass19> c = cb.createQuery(MyClass19.class);
		javax.persistence.criteria.Root<MyClass19> emp = c.from(MyClass19.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass19Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass19> q = this.entityManager.createQuery(c);
		
		if (myClass19Criteria.getId()!=null ){
			q.setParameter("id", myClass19Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass19>(q.getResultList());	
	}

	
	public MyClass19 findById (Long id) 
	{
		return this.entityManager.find (MyClass19.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass19 save (MyClass19 myclass19) 
	{
		if (myclass19.getId() != null) {
			return this.entityManager.merge(myclass19);
		} else {
			this.entityManager.persist(myclass19);
			return myclass19;
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
