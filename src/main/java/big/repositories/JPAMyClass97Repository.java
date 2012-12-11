package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.domain.MyClass97;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass97Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass97Repository")
public class JPAMyClass97Repository implements MyClass97Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass97> findAll () 
	{
		final String hql = "select e from MyClass97 e order by id";
		TypedQuery<MyClass97> query =
			this.entityManager.createQuery(hql, MyClass97.class);
		return query.getResultList();	
	}

	
	public List<MyClass97> findByCriteria (MyClass97Criteria myClass97Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass97> c = cb.createQuery(MyClass97.class);
		javax.persistence.criteria.Root<MyClass97> emp = c.from(MyClass97.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass97Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass97Criteria.getMyclass133()!=null && myClass97Criteria.getMyclass133().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass133> val = cb.parameter(big.domain.MyClass133.class, "myclass133");	
			criteria.add(cb.equal(emp.get("myclass133"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass97> q = this.entityManager.createQuery(c);
		
		if (myClass97Criteria.getId()!=null ){
			q.setParameter("id", myClass97Criteria.getId());
		}
		if (myClass97Criteria.getMyclass133()!=null && myClass97Criteria.getMyclass133().getId() > 0 ){
			q.setParameter("myclass133", myClass97Criteria.getMyclass133());
		}
		    
		return new java.util.ArrayList<MyClass97>(q.getResultList());	
	}

	
	public MyClass97 findById (Long id) 
	{
		return this.entityManager.find (MyClass97.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass97 save (MyClass97 myclass97) 
	{
		if (myclass97.getId() != null) {
			return this.entityManager.merge(myclass97);
		} else {
			this.entityManager.persist(myclass97);
			return myclass97;
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
