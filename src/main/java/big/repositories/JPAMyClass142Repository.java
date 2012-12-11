package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass142;
import big.repositories.criteria.MyClass142Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass142Repository")
public class JPAMyClass142Repository implements MyClass142Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass142> findAll () 
	{
		final String hql = "select e from MyClass142 e order by id";
		TypedQuery<MyClass142> query =
			this.entityManager.createQuery(hql, MyClass142.class);
		return query.getResultList();	
	}

	
	public List<MyClass142> findByCriteria (MyClass142Criteria myClass142Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass142> c = cb.createQuery(MyClass142.class);
		javax.persistence.criteria.Root<MyClass142> emp = c.from(MyClass142.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass142Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass142> q = this.entityManager.createQuery(c);
		
		if (myClass142Criteria.getId()!=null ){
			q.setParameter("id", myClass142Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass142>(q.getResultList());	
	}

	
	public MyClass142 findById (Long id) 
	{
		return this.entityManager.find (MyClass142.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass142 save (MyClass142 myclass142) 
	{
		if (myclass142.getId() != null) {
			return this.entityManager.merge(myclass142);
		} else {
			this.entityManager.persist(myclass142);
			return myclass142;
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
