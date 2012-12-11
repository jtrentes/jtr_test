package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass132Criteria;
import big.domain.MyClass132;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass132Repository")
public class JPAMyClass132Repository implements MyClass132Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass132> findAll () 
	{
		final String hql = "select e from MyClass132 e order by id";
		TypedQuery<MyClass132> query =
			this.entityManager.createQuery(hql, MyClass132.class);
		return query.getResultList();	
	}

	
	public List<MyClass132> findByCriteria (MyClass132Criteria myClass132Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass132> c = cb.createQuery(MyClass132.class);
		javax.persistence.criteria.Root<MyClass132> emp = c.from(MyClass132.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass132Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass132> q = this.entityManager.createQuery(c);
		
		if (myClass132Criteria.getId()!=null ){
			q.setParameter("id", myClass132Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass132>(q.getResultList());	
	}

	
	public MyClass132 findById (Long id) 
	{
		return this.entityManager.find (MyClass132.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass132 save (MyClass132 myclass132) 
	{
		if (myclass132.getId() != null) {
			return this.entityManager.merge(myclass132);
		} else {
			this.entityManager.persist(myclass132);
			return myclass132;
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
