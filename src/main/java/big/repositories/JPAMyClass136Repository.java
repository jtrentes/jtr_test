package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass136Criteria;
import big.domain.MyClass136;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass136Repository")
public class JPAMyClass136Repository implements MyClass136Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass136> findAll () 
	{
		final String hql = "select e from MyClass136 e order by id";
		TypedQuery<MyClass136> query =
			this.entityManager.createQuery(hql, MyClass136.class);
		return query.getResultList();	
	}

	
	public List<MyClass136> findByCriteria (MyClass136Criteria myClass136Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass136> c = cb.createQuery(MyClass136.class);
		javax.persistence.criteria.Root<MyClass136> emp = c.from(MyClass136.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass136Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass136> q = this.entityManager.createQuery(c);
		
		if (myClass136Criteria.getId()!=null ){
			q.setParameter("id", myClass136Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass136>(q.getResultList());	
	}

	
	public MyClass136 findById (Long id) 
	{
		return this.entityManager.find (MyClass136.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass136 save (MyClass136 myclass136) 
	{
		if (myclass136.getId() != null) {
			return this.entityManager.merge(myclass136);
		} else {
			this.entityManager.persist(myclass136);
			return myclass136;
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
