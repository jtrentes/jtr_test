package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass153;
import java.util.List;
import big.repositories.criteria.MyClass153Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass153Repository")
public class JPAMyClass153Repository implements MyClass153Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass153> findAll () 
	{
		final String hql = "select e from MyClass153 e order by id";
		TypedQuery<MyClass153> query =
			this.entityManager.createQuery(hql, MyClass153.class);
		return query.getResultList();	
	}

	
	public List<MyClass153> findByCriteria (MyClass153Criteria myClass153Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass153> c = cb.createQuery(MyClass153.class);
		javax.persistence.criteria.Root<MyClass153> emp = c.from(MyClass153.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass153Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass153> q = this.entityManager.createQuery(c);
		
		if (myClass153Criteria.getId()!=null ){
			q.setParameter("id", myClass153Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass153>(q.getResultList());	
	}

	
	public MyClass153 findById (Long id) 
	{
		return this.entityManager.find (MyClass153.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass153 save (MyClass153 myclass153) 
	{
		if (myclass153.getId() != null) {
			return this.entityManager.merge(myclass153);
		} else {
			this.entityManager.persist(myclass153);
			return myclass153;
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
