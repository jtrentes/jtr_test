package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass104;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass104Criteria;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass104Repository")
public class JPAMyClass104Repository implements MyClass104Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass104> findAll () 
	{
		final String hql = "select e from MyClass104 e order by id";
		TypedQuery<MyClass104> query =
			this.entityManager.createQuery(hql, MyClass104.class);
		return query.getResultList();	
	}

	
	public List<MyClass104> findByCriteria (MyClass104Criteria myClass104Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass104> c = cb.createQuery(MyClass104.class);
		javax.persistence.criteria.Root<MyClass104> emp = c.from(MyClass104.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass104Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass104> q = this.entityManager.createQuery(c);
		
		if (myClass104Criteria.getId()!=null ){
			q.setParameter("id", myClass104Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass104>(q.getResultList());	
	}

	
	public MyClass104 findById (Long id) 
	{
		return this.entityManager.find (MyClass104.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass104 save (MyClass104 myclass104) 
	{
		if (myclass104.getId() != null) {
			return this.entityManager.merge(myclass104);
		} else {
			this.entityManager.persist(myclass104);
			return myclass104;
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
