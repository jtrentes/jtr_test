package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass53;
import big.repositories.criteria.MyClass53Criteria;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass53Repository")
public class JPAMyClass53Repository implements MyClass53Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass53> findAll () 
	{
		final String hql = "select e from MyClass53 e order by id";
		TypedQuery<MyClass53> query =
			this.entityManager.createQuery(hql, MyClass53.class);
		return query.getResultList();	
	}

	
	public List<MyClass53> findByCriteria (MyClass53Criteria myClass53Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass53> c = cb.createQuery(MyClass53.class);
		javax.persistence.criteria.Root<MyClass53> emp = c.from(MyClass53.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass53Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass53> q = this.entityManager.createQuery(c);
		
		if (myClass53Criteria.getId()!=null ){
			q.setParameter("id", myClass53Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass53>(q.getResultList());	
	}

	
	public MyClass53 findById (Long id) 
	{
		return this.entityManager.find (MyClass53.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass53 save (MyClass53 myclass53) 
	{
		if (myclass53.getId() != null) {
			return this.entityManager.merge(myclass53);
		} else {
			this.entityManager.persist(myclass53);
			return myclass53;
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
