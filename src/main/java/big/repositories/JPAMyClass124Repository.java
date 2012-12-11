package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass124Criteria;
import big.domain.MyClass124;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass124Repository")
public class JPAMyClass124Repository implements MyClass124Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass124> findAll () 
	{
		final String hql = "select e from MyClass124 e order by id";
		TypedQuery<MyClass124> query =
			this.entityManager.createQuery(hql, MyClass124.class);
		return query.getResultList();	
	}

	
	public List<MyClass124> findByCriteria (MyClass124Criteria myClass124Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass124> c = cb.createQuery(MyClass124.class);
		javax.persistence.criteria.Root<MyClass124> emp = c.from(MyClass124.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass124Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass124Criteria.getMyclass140()!=null && myClass124Criteria.getMyclass140().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass140> val = cb.parameter(big.domain.MyClass140.class, "myclass140");	
			criteria.add(cb.equal(emp.get("myclass140"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass124> q = this.entityManager.createQuery(c);
		
		if (myClass124Criteria.getId()!=null ){
			q.setParameter("id", myClass124Criteria.getId());
		}
		if (myClass124Criteria.getMyclass140()!=null && myClass124Criteria.getMyclass140().getId() > 0 ){
			q.setParameter("myclass140", myClass124Criteria.getMyclass140());
		}
		    
		return new java.util.ArrayList<MyClass124>(q.getResultList());	
	}

	
	public MyClass124 findById (Long id) 
	{
		return this.entityManager.find (MyClass124.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass124 save (MyClass124 myclass124) 
	{
		if (myclass124.getId() != null) {
			return this.entityManager.merge(myclass124);
		} else {
			this.entityManager.persist(myclass124);
			return myclass124;
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
