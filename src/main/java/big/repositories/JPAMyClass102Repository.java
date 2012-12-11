package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass102Criteria;
import java.util.List;
import big.domain.MyClass102;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass102Repository")
public class JPAMyClass102Repository implements MyClass102Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass102> findAll () 
	{
		final String hql = "select e from MyClass102 e order by id";
		TypedQuery<MyClass102> query =
			this.entityManager.createQuery(hql, MyClass102.class);
		return query.getResultList();	
	}

	
	public List<MyClass102> findByCriteria (MyClass102Criteria myClass102Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass102> c = cb.createQuery(MyClass102.class);
		javax.persistence.criteria.Root<MyClass102> emp = c.from(MyClass102.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass102Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass102Criteria.getMyclass111()!=null && myClass102Criteria.getMyclass111().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass111> val = cb.parameter(big.domain.MyClass111.class, "myclass111");	
			criteria.add(cb.equal(emp.get("myclass111"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass102> q = this.entityManager.createQuery(c);
		
		if (myClass102Criteria.getId()!=null ){
			q.setParameter("id", myClass102Criteria.getId());
		}
		if (myClass102Criteria.getMyclass111()!=null && myClass102Criteria.getMyclass111().getId() > 0 ){
			q.setParameter("myclass111", myClass102Criteria.getMyclass111());
		}
		    
		return new java.util.ArrayList<MyClass102>(q.getResultList());	
	}

	
	public MyClass102 findById (Long id) 
	{
		return this.entityManager.find (MyClass102.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass102 save (MyClass102 myclass102) 
	{
		if (myclass102.getId() != null) {
			return this.entityManager.merge(myclass102);
		} else {
			this.entityManager.persist(myclass102);
			return myclass102;
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
