package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass150Criteria;
import big.domain.MyClass150;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass150Repository")
public class JPAMyClass150Repository implements MyClass150Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass150> findAll () 
	{
		final String hql = "select e from MyClass150 e order by id";
		TypedQuery<MyClass150> query =
			this.entityManager.createQuery(hql, MyClass150.class);
		return query.getResultList();	
	}

	
	public List<MyClass150> findByCriteria (MyClass150Criteria myClass150Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass150> c = cb.createQuery(MyClass150.class);
		javax.persistence.criteria.Root<MyClass150> emp = c.from(MyClass150.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass150Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass150> q = this.entityManager.createQuery(c);
		
		if (myClass150Criteria.getId()!=null ){
			q.setParameter("id", myClass150Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass150>(q.getResultList());	
	}

	
	public MyClass150 findById (Long id) 
	{
		return this.entityManager.find (MyClass150.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass150 save (MyClass150 myclass150) 
	{
		if (myclass150.getId() != null) {
			return this.entityManager.merge(myclass150);
		} else {
			this.entityManager.persist(myclass150);
			return myclass150;
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
