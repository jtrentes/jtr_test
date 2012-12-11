package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass61Criteria;
import java.util.List;
import big.domain.MyClass61;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass61Repository")
public class JPAMyClass61Repository implements MyClass61Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass61> findAll () 
	{
		final String hql = "select e from MyClass61 e order by id";
		TypedQuery<MyClass61> query =
			this.entityManager.createQuery(hql, MyClass61.class);
		return query.getResultList();	
	}

	
	public List<MyClass61> findByCriteria (MyClass61Criteria myClass61Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass61> c = cb.createQuery(MyClass61.class);
		javax.persistence.criteria.Root<MyClass61> emp = c.from(MyClass61.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass61Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass61> q = this.entityManager.createQuery(c);
		
		if (myClass61Criteria.getId()!=null ){
			q.setParameter("id", myClass61Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass61>(q.getResultList());	
	}

	
	public MyClass61 findById (Long id) 
	{
		return this.entityManager.find (MyClass61.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass61 save (MyClass61 myclass61) 
	{
		if (myclass61.getId() != null) {
			return this.entityManager.merge(myclass61);
		} else {
			this.entityManager.persist(myclass61);
			return myclass61;
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
