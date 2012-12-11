package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass126;
import big.repositories.criteria.MyClass126Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass126Repository")
public class JPAMyClass126Repository implements MyClass126Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass126> findAll () 
	{
		final String hql = "select e from MyClass126 e order by id";
		TypedQuery<MyClass126> query =
			this.entityManager.createQuery(hql, MyClass126.class);
		return query.getResultList();	
	}

	
	public List<MyClass126> findByCriteria (MyClass126Criteria myClass126Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass126> c = cb.createQuery(MyClass126.class);
		javax.persistence.criteria.Root<MyClass126> emp = c.from(MyClass126.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass126Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass126> q = this.entityManager.createQuery(c);
		
		if (myClass126Criteria.getId()!=null ){
			q.setParameter("id", myClass126Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass126>(q.getResultList());	
	}

	
	public MyClass126 findById (Long id) 
	{
		return this.entityManager.find (MyClass126.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass126 save (MyClass126 myclass126) 
	{
		if (myclass126.getId() != null) {
			return this.entityManager.merge(myclass126);
		} else {
			this.entityManager.persist(myclass126);
			return myclass126;
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
