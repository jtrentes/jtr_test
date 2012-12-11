package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass20;
import java.util.List;
import big.repositories.criteria.MyClass20Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass20Repository")
public class JPAMyClass20Repository implements MyClass20Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass20> findAll () 
	{
		final String hql = "select e from MyClass20 e order by id";
		TypedQuery<MyClass20> query =
			this.entityManager.createQuery(hql, MyClass20.class);
		return query.getResultList();	
	}

	
	public List<MyClass20> findByCriteria (MyClass20Criteria myClass20Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass20> c = cb.createQuery(MyClass20.class);
		javax.persistence.criteria.Root<MyClass20> emp = c.from(MyClass20.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass20Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass20> q = this.entityManager.createQuery(c);
		
		if (myClass20Criteria.getId()!=null ){
			q.setParameter("id", myClass20Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass20>(q.getResultList());	
	}

	
	public MyClass20 findById (Long id) 
	{
		return this.entityManager.find (MyClass20.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass20 save (MyClass20 myclass20) 
	{
		if (myclass20.getId() != null) {
			return this.entityManager.merge(myclass20);
		} else {
			this.entityManager.persist(myclass20);
			return myclass20;
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
