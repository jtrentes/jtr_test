package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass65Criteria;
import big.domain.MyClass65;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass65Repository")
public class JPAMyClass65Repository implements MyClass65Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass65> findAll () 
	{
		final String hql = "select e from MyClass65 e order by id";
		TypedQuery<MyClass65> query =
			this.entityManager.createQuery(hql, MyClass65.class);
		return query.getResultList();	
	}

	
	public List<MyClass65> findByCriteria (MyClass65Criteria myClass65Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass65> c = cb.createQuery(MyClass65.class);
		javax.persistence.criteria.Root<MyClass65> emp = c.from(MyClass65.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass65Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass65> q = this.entityManager.createQuery(c);
		
		if (myClass65Criteria.getId()!=null ){
			q.setParameter("id", myClass65Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass65>(q.getResultList());	
	}

	
	public MyClass65 findById (Long id) 
	{
		return this.entityManager.find (MyClass65.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass65 save (MyClass65 myclass65) 
	{
		if (myclass65.getId() != null) {
			return this.entityManager.merge(myclass65);
		} else {
			this.entityManager.persist(myclass65);
			return myclass65;
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
