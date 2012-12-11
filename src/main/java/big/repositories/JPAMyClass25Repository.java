package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass25;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass25Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass25Repository")
public class JPAMyClass25Repository implements MyClass25Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass25> findAll () 
	{
		final String hql = "select e from MyClass25 e order by id";
		TypedQuery<MyClass25> query =
			this.entityManager.createQuery(hql, MyClass25.class);
		return query.getResultList();	
	}

	
	public List<MyClass25> findByCriteria (MyClass25Criteria myClass25Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass25> c = cb.createQuery(MyClass25.class);
		javax.persistence.criteria.Root<MyClass25> emp = c.from(MyClass25.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass25Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass25Criteria.getMyclass57()!=null && myClass25Criteria.getMyclass57().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass57> val = cb.parameter(big.domain.MyClass57.class, "myclass57");	
			criteria.add(cb.equal(emp.get("myclass57"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass25> q = this.entityManager.createQuery(c);
		
		if (myClass25Criteria.getId()!=null ){
			q.setParameter("id", myClass25Criteria.getId());
		}
		if (myClass25Criteria.getMyclass57()!=null && myClass25Criteria.getMyclass57().getId() > 0 ){
			q.setParameter("myclass57", myClass25Criteria.getMyclass57());
		}
		    
		return new java.util.ArrayList<MyClass25>(q.getResultList());	
	}

	
	public MyClass25 findById (Long id) 
	{
		return this.entityManager.find (MyClass25.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass25 save (MyClass25 myclass25) 
	{
		if (myclass25.getId() != null) {
			return this.entityManager.merge(myclass25);
		} else {
			this.entityManager.persist(myclass25);
			return myclass25;
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
