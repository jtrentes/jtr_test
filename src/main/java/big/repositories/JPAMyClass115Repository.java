package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass115;
import big.repositories.criteria.MyClass115Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass115Repository")
public class JPAMyClass115Repository implements MyClass115Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass115> findAll () 
	{
		final String hql = "select e from MyClass115 e order by id";
		TypedQuery<MyClass115> query =
			this.entityManager.createQuery(hql, MyClass115.class);
		return query.getResultList();	
	}

	
	public List<MyClass115> findByCriteria (MyClass115Criteria myClass115Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass115> c = cb.createQuery(MyClass115.class);
		javax.persistence.criteria.Root<MyClass115> emp = c.from(MyClass115.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass115Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass115Criteria.getMyclass50()!=null && myClass115Criteria.getMyclass50().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass50> val = cb.parameter(big.domain.MyClass50.class, "myclass50");	
			criteria.add(cb.equal(emp.get("myclass50"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass115> q = this.entityManager.createQuery(c);
		
		if (myClass115Criteria.getId()!=null ){
			q.setParameter("id", myClass115Criteria.getId());
		}
		if (myClass115Criteria.getMyclass50()!=null && myClass115Criteria.getMyclass50().getId() > 0 ){
			q.setParameter("myclass50", myClass115Criteria.getMyclass50());
		}
		    
		return new java.util.ArrayList<MyClass115>(q.getResultList());	
	}

	
	public MyClass115 findById (Long id) 
	{
		return this.entityManager.find (MyClass115.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass115 save (MyClass115 myclass115) 
	{
		if (myclass115.getId() != null) {
			return this.entityManager.merge(myclass115);
		} else {
			this.entityManager.persist(myclass115);
			return myclass115;
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
