package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass42Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass42;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass42Repository")
public class JPAMyClass42Repository implements MyClass42Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass42> findAll () 
	{
		final String hql = "select e from MyClass42 e order by id";
		TypedQuery<MyClass42> query =
			this.entityManager.createQuery(hql, MyClass42.class);
		return query.getResultList();	
	}

	
	public List<MyClass42> findByCriteria (MyClass42Criteria myClass42Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass42> c = cb.createQuery(MyClass42.class);
		javax.persistence.criteria.Root<MyClass42> emp = c.from(MyClass42.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass42Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass42> q = this.entityManager.createQuery(c);
		
		if (myClass42Criteria.getId()!=null ){
			q.setParameter("id", myClass42Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass42>(q.getResultList());	
	}

	
	public MyClass42 findById (Long id) 
	{
		return this.entityManager.find (MyClass42.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass42 save (MyClass42 myclass42) 
	{
		if (myclass42.getId() != null) {
			return this.entityManager.merge(myclass42);
		} else {
			this.entityManager.persist(myclass42);
			return myclass42;
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
