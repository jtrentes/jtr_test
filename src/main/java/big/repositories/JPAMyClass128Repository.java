package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass128Criteria;
import javax.persistence.EntityManager;
import big.domain.MyClass128;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass128Repository")
public class JPAMyClass128Repository implements MyClass128Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass128> findAll () 
	{
		final String hql = "select e from MyClass128 e order by id";
		TypedQuery<MyClass128> query =
			this.entityManager.createQuery(hql, MyClass128.class);
		return query.getResultList();	
	}

	
	public List<MyClass128> findByCriteria (MyClass128Criteria myClass128Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass128> c = cb.createQuery(MyClass128.class);
		javax.persistence.criteria.Root<MyClass128> emp = c.from(MyClass128.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass128Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass128> q = this.entityManager.createQuery(c);
		
		if (myClass128Criteria.getId()!=null ){
			q.setParameter("id", myClass128Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass128>(q.getResultList());	
	}

	
	public MyClass128 findById (Long id) 
	{
		return this.entityManager.find (MyClass128.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass128 save (MyClass128 myclass128) 
	{
		if (myclass128.getId() != null) {
			return this.entityManager.merge(myclass128);
		} else {
			this.entityManager.persist(myclass128);
			return myclass128;
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
