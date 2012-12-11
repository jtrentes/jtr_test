package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass56Criteria;
import big.domain.MyClass56;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass56Repository")
public class JPAMyClass56Repository implements MyClass56Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass56> findAll () 
	{
		final String hql = "select e from MyClass56 e order by id";
		TypedQuery<MyClass56> query =
			this.entityManager.createQuery(hql, MyClass56.class);
		return query.getResultList();	
	}

	
	public List<MyClass56> findByCriteria (MyClass56Criteria myClass56Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass56> c = cb.createQuery(MyClass56.class);
		javax.persistence.criteria.Root<MyClass56> emp = c.from(MyClass56.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass56Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass56> q = this.entityManager.createQuery(c);
		
		if (myClass56Criteria.getId()!=null ){
			q.setParameter("id", myClass56Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass56>(q.getResultList());	
	}

	
	public MyClass56 findById (Long id) 
	{
		return this.entityManager.find (MyClass56.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass56 save (MyClass56 myclass56) 
	{
		if (myclass56.getId() != null) {
			return this.entityManager.merge(myclass56);
		} else {
			this.entityManager.persist(myclass56);
			return myclass56;
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
