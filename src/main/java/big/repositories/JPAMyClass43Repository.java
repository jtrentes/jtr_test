package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass43Criteria;
import big.domain.MyClass43;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass43Repository")
public class JPAMyClass43Repository implements MyClass43Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass43> findAll () 
	{
		final String hql = "select e from MyClass43 e order by id";
		TypedQuery<MyClass43> query =
			this.entityManager.createQuery(hql, MyClass43.class);
		return query.getResultList();	
	}

	
	public List<MyClass43> findByCriteria (MyClass43Criteria myClass43Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass43> c = cb.createQuery(MyClass43.class);
		javax.persistence.criteria.Root<MyClass43> emp = c.from(MyClass43.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass43Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass43Criteria.getMyclass34()!=null && myClass43Criteria.getMyclass34().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass34> val = cb.parameter(big.domain.MyClass34.class, "myclass34");	
			criteria.add(cb.equal(emp.get("myclass34"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass43> q = this.entityManager.createQuery(c);
		
		if (myClass43Criteria.getId()!=null ){
			q.setParameter("id", myClass43Criteria.getId());
		}
		if (myClass43Criteria.getMyclass34()!=null && myClass43Criteria.getMyclass34().getId() > 0 ){
			q.setParameter("myclass34", myClass43Criteria.getMyclass34());
		}
		    
		return new java.util.ArrayList<MyClass43>(q.getResultList());	
	}

	
	public MyClass43 findById (Long id) 
	{
		return this.entityManager.find (MyClass43.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass43 save (MyClass43 myclass43) 
	{
		if (myclass43.getId() != null) {
			return this.entityManager.merge(myclass43);
		} else {
			this.entityManager.persist(myclass43);
			return myclass43;
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
