package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass3Criteria;
import big.domain.MyClass3;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass3Repository")
public class JPAMyClass3Repository implements MyClass3Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass3> findAll () 
	{
		final String hql = "select e from MyClass3 e order by id";
		TypedQuery<MyClass3> query =
			this.entityManager.createQuery(hql, MyClass3.class);
		return query.getResultList();	
	}

	
	public List<MyClass3> findByCriteria (MyClass3Criteria myClass3Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass3> c = cb.createQuery(MyClass3.class);
		javax.persistence.criteria.Root<MyClass3> emp = c.from(MyClass3.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass3Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass3Criteria.getMyclass2()!=null && myClass3Criteria.getMyclass2().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass2> val = cb.parameter(big.domain.MyClass2.class, "myclass2");	
			criteria.add(cb.equal(emp.get("myclass2"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass3> q = this.entityManager.createQuery(c);
		
		if (myClass3Criteria.getId()!=null ){
			q.setParameter("id", myClass3Criteria.getId());
		}
		if (myClass3Criteria.getMyclass2()!=null && myClass3Criteria.getMyclass2().getId() > 0 ){
			q.setParameter("myclass2", myClass3Criteria.getMyclass2());
		}
		    
		return new java.util.ArrayList<MyClass3>(q.getResultList());	
	}

	
	public MyClass3 findById (Long id) 
	{
		return this.entityManager.find (MyClass3.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass3 save (MyClass3 myclass3) 
	{
		if (myclass3.getId() != null) {
			return this.entityManager.merge(myclass3);
		} else {
			this.entityManager.persist(myclass3);
			return myclass3;
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
