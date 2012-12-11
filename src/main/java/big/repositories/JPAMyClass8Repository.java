package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass8;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass8Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass8Repository")
public class JPAMyClass8Repository implements MyClass8Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass8> findAll () 
	{
		final String hql = "select e from MyClass8 e order by id";
		TypedQuery<MyClass8> query =
			this.entityManager.createQuery(hql, MyClass8.class);
		return query.getResultList();	
	}

	
	public List<MyClass8> findByCriteria (MyClass8Criteria myClass8Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass8> c = cb.createQuery(MyClass8.class);
		javax.persistence.criteria.Root<MyClass8> emp = c.from(MyClass8.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass8Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass8Criteria.getMyclass7()!=null && myClass8Criteria.getMyclass7().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass7> val = cb.parameter(big.domain.MyClass7.class, "myclass7");	
			criteria.add(cb.equal(emp.get("myclass7"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass8> q = this.entityManager.createQuery(c);
		
		if (myClass8Criteria.getId()!=null ){
			q.setParameter("id", myClass8Criteria.getId());
		}
		if (myClass8Criteria.getMyclass7()!=null && myClass8Criteria.getMyclass7().getId() > 0 ){
			q.setParameter("myclass7", myClass8Criteria.getMyclass7());
		}
		    
		return new java.util.ArrayList<MyClass8>(q.getResultList());	
	}

	
	public MyClass8 findById (Long id) 
	{
		return this.entityManager.find (MyClass8.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass8 save (MyClass8 myclass8) 
	{
		if (myclass8.getId() != null) {
			return this.entityManager.merge(myclass8);
		} else {
			this.entityManager.persist(myclass8);
			return myclass8;
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
