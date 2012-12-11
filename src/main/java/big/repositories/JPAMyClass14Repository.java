package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass14Criteria;
import big.domain.MyClass14;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass14Repository")
public class JPAMyClass14Repository implements MyClass14Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass14> findAll () 
	{
		final String hql = "select e from MyClass14 e order by id";
		TypedQuery<MyClass14> query =
			this.entityManager.createQuery(hql, MyClass14.class);
		return query.getResultList();	
	}

	
	public List<MyClass14> findByCriteria (MyClass14Criteria myClass14Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass14> c = cb.createQuery(MyClass14.class);
		javax.persistence.criteria.Root<MyClass14> emp = c.from(MyClass14.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass14Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass14> q = this.entityManager.createQuery(c);
		
		if (myClass14Criteria.getId()!=null ){
			q.setParameter("id", myClass14Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass14>(q.getResultList());	
	}

	
	public MyClass14 findById (Long id) 
	{
		return this.entityManager.find (MyClass14.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass14 save (MyClass14 myclass14) 
	{
		if (myclass14.getId() != null) {
			return this.entityManager.merge(myclass14);
		} else {
			this.entityManager.persist(myclass14);
			return myclass14;
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
