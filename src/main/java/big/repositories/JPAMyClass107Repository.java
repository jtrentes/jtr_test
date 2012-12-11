package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass107;
import big.repositories.criteria.MyClass107Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass107Repository")
public class JPAMyClass107Repository implements MyClass107Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass107> findAll () 
	{
		final String hql = "select e from MyClass107 e order by id";
		TypedQuery<MyClass107> query =
			this.entityManager.createQuery(hql, MyClass107.class);
		return query.getResultList();	
	}

	
	public List<MyClass107> findByCriteria (MyClass107Criteria myClass107Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass107> c = cb.createQuery(MyClass107.class);
		javax.persistence.criteria.Root<MyClass107> emp = c.from(MyClass107.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass107Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass107Criteria.getMyclass112()!=null && myClass107Criteria.getMyclass112().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass112> val = cb.parameter(big.domain.MyClass112.class, "myclass112");	
			criteria.add(cb.equal(emp.get("myclass112"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass107> q = this.entityManager.createQuery(c);
		
		if (myClass107Criteria.getId()!=null ){
			q.setParameter("id", myClass107Criteria.getId());
		}
		if (myClass107Criteria.getMyclass112()!=null && myClass107Criteria.getMyclass112().getId() > 0 ){
			q.setParameter("myclass112", myClass107Criteria.getMyclass112());
		}
		    
		return new java.util.ArrayList<MyClass107>(q.getResultList());	
	}

	
	public MyClass107 findById (Long id) 
	{
		return this.entityManager.find (MyClass107.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass107 save (MyClass107 myclass107) 
	{
		if (myclass107.getId() != null) {
			return this.entityManager.merge(myclass107);
		} else {
			this.entityManager.persist(myclass107);
			return myclass107;
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
