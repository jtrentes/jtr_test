package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass74;
import big.repositories.criteria.MyClass74Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass74Repository")
public class JPAMyClass74Repository implements MyClass74Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass74> findAll () 
	{
		final String hql = "select e from MyClass74 e order by id";
		TypedQuery<MyClass74> query =
			this.entityManager.createQuery(hql, MyClass74.class);
		return query.getResultList();	
	}

	
	public List<MyClass74> findByCriteria (MyClass74Criteria myClass74Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass74> c = cb.createQuery(MyClass74.class);
		javax.persistence.criteria.Root<MyClass74> emp = c.from(MyClass74.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass74Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass74Criteria.getMyclass117()!=null && myClass74Criteria.getMyclass117().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass117> val = cb.parameter(big.domain.MyClass117.class, "myclass117");	
			criteria.add(cb.equal(emp.get("myclass117"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass74> q = this.entityManager.createQuery(c);
		
		if (myClass74Criteria.getId()!=null ){
			q.setParameter("id", myClass74Criteria.getId());
		}
		if (myClass74Criteria.getMyclass117()!=null && myClass74Criteria.getMyclass117().getId() > 0 ){
			q.setParameter("myclass117", myClass74Criteria.getMyclass117());
		}
		    
		return new java.util.ArrayList<MyClass74>(q.getResultList());	
	}

	
	public MyClass74 findById (Long id) 
	{
		return this.entityManager.find (MyClass74.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass74 save (MyClass74 myclass74) 
	{
		if (myclass74.getId() != null) {
			return this.entityManager.merge(myclass74);
		} else {
			this.entityManager.persist(myclass74);
			return myclass74;
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
