package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass32;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass32Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass32Repository")
public class JPAMyClass32Repository implements MyClass32Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass32> findAll () 
	{
		final String hql = "select e from MyClass32 e order by id";
		TypedQuery<MyClass32> query =
			this.entityManager.createQuery(hql, MyClass32.class);
		return query.getResultList();	
	}

	
	public List<MyClass32> findByCriteria (MyClass32Criteria myClass32Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass32> c = cb.createQuery(MyClass32.class);
		javax.persistence.criteria.Root<MyClass32> emp = c.from(MyClass32.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass32Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass32Criteria.getMyclass62()!=null && myClass32Criteria.getMyclass62().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass62> val = cb.parameter(big.domain.MyClass62.class, "myclass62");	
			criteria.add(cb.equal(emp.get("myclass62"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass32> q = this.entityManager.createQuery(c);
		
		if (myClass32Criteria.getId()!=null ){
			q.setParameter("id", myClass32Criteria.getId());
		}
		if (myClass32Criteria.getMyclass62()!=null && myClass32Criteria.getMyclass62().getId() > 0 ){
			q.setParameter("myclass62", myClass32Criteria.getMyclass62());
		}
		    
		return new java.util.ArrayList<MyClass32>(q.getResultList());	
	}

	
	public MyClass32 findById (Long id) 
	{
		return this.entityManager.find (MyClass32.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass32 save (MyClass32 myclass32) 
	{
		if (myclass32.getId() != null) {
			return this.entityManager.merge(myclass32);
		} else {
			this.entityManager.persist(myclass32);
			return myclass32;
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
