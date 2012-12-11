package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass28Criteria;
import big.domain.MyClass28;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass28Repository")
public class JPAMyClass28Repository implements MyClass28Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass28> findAll () 
	{
		final String hql = "select e from MyClass28 e order by id";
		TypedQuery<MyClass28> query =
			this.entityManager.createQuery(hql, MyClass28.class);
		return query.getResultList();	
	}

	
	public List<MyClass28> findByCriteria (MyClass28Criteria myClass28Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass28> c = cb.createQuery(MyClass28.class);
		javax.persistence.criteria.Root<MyClass28> emp = c.from(MyClass28.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass28Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass28Criteria.getMyclass25()!=null && myClass28Criteria.getMyclass25().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass25> val = cb.parameter(big.domain.MyClass25.class, "myclass25");	
			criteria.add(cb.equal(emp.get("myclass25"),val));
		}
		if (myClass28Criteria.getMyclass115()!=null && myClass28Criteria.getMyclass115().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass115> val = cb.parameter(big.domain.MyClass115.class, "myclass115");	
			criteria.add(cb.equal(emp.get("myclass115"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass28> q = this.entityManager.createQuery(c);
		
		if (myClass28Criteria.getId()!=null ){
			q.setParameter("id", myClass28Criteria.getId());
		}
		if (myClass28Criteria.getMyclass25()!=null && myClass28Criteria.getMyclass25().getId() > 0 ){
			q.setParameter("myclass25", myClass28Criteria.getMyclass25());
		}
		if (myClass28Criteria.getMyclass115()!=null && myClass28Criteria.getMyclass115().getId() > 0 ){
			q.setParameter("myclass115", myClass28Criteria.getMyclass115());
		}
		    
		return new java.util.ArrayList<MyClass28>(q.getResultList());	
	}

	
	public MyClass28 findById (Long id) 
	{
		return this.entityManager.find (MyClass28.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass28 save (MyClass28 myclass28) 
	{
		if (myclass28.getId() != null) {
			return this.entityManager.merge(myclass28);
		} else {
			this.entityManager.persist(myclass28);
			return myclass28;
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
