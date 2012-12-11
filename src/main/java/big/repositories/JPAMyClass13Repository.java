package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass13;
import big.repositories.criteria.MyClass13Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass13Repository")
public class JPAMyClass13Repository implements MyClass13Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass13> findAll () 
	{
		final String hql = "select e from MyClass13 e order by id";
		TypedQuery<MyClass13> query =
			this.entityManager.createQuery(hql, MyClass13.class);
		return query.getResultList();	
	}

	
	public List<MyClass13> findByCriteria (MyClass13Criteria myClass13Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass13> c = cb.createQuery(MyClass13.class);
		javax.persistence.criteria.Root<MyClass13> emp = c.from(MyClass13.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass13Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass13> q = this.entityManager.createQuery(c);
		
		if (myClass13Criteria.getId()!=null ){
			q.setParameter("id", myClass13Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass13>(q.getResultList());	
	}

	
	public MyClass13 findById (Long id) 
	{
		return this.entityManager.find (MyClass13.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass13 save (MyClass13 myclass13) 
	{
		if (myclass13.getId() != null) {
			return this.entityManager.merge(myclass13);
		} else {
			this.entityManager.persist(myclass13);
			return myclass13;
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
