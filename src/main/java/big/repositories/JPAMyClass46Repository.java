package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass46;
import big.repositories.criteria.MyClass46Criteria;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass46Repository")
public class JPAMyClass46Repository implements MyClass46Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass46> findAll () 
	{
		final String hql = "select e from MyClass46 e order by id";
		TypedQuery<MyClass46> query =
			this.entityManager.createQuery(hql, MyClass46.class);
		return query.getResultList();	
	}

	
	public List<MyClass46> findByCriteria (MyClass46Criteria myClass46Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass46> c = cb.createQuery(MyClass46.class);
		javax.persistence.criteria.Root<MyClass46> emp = c.from(MyClass46.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass46Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass46Criteria.getMyclass30()!=null && myClass46Criteria.getMyclass30().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass30> val = cb.parameter(big.domain.MyClass30.class, "myclass30");	
			criteria.add(cb.equal(emp.get("myclass30"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass46> q = this.entityManager.createQuery(c);
		
		if (myClass46Criteria.getId()!=null ){
			q.setParameter("id", myClass46Criteria.getId());
		}
		if (myClass46Criteria.getMyclass30()!=null && myClass46Criteria.getMyclass30().getId() > 0 ){
			q.setParameter("myclass30", myClass46Criteria.getMyclass30());
		}
		    
		return new java.util.ArrayList<MyClass46>(q.getResultList());	
	}

	
	public MyClass46 findById (Long id) 
	{
		return this.entityManager.find (MyClass46.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass46 save (MyClass46 myclass46) 
	{
		if (myclass46.getId() != null) {
			return this.entityManager.merge(myclass46);
		} else {
			this.entityManager.persist(myclass46);
			return myclass46;
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
