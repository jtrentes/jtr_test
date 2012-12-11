package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass148Criteria;
import java.util.List;
import big.domain.MyClass148;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass148Repository")
public class JPAMyClass148Repository implements MyClass148Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass148> findAll () 
	{
		final String hql = "select e from MyClass148 e order by id";
		TypedQuery<MyClass148> query =
			this.entityManager.createQuery(hql, MyClass148.class);
		return query.getResultList();	
	}

	
	public List<MyClass148> findByCriteria (MyClass148Criteria myClass148Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass148> c = cb.createQuery(MyClass148.class);
		javax.persistence.criteria.Root<MyClass148> emp = c.from(MyClass148.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass148Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass148> q = this.entityManager.createQuery(c);
		
		if (myClass148Criteria.getId()!=null ){
			q.setParameter("id", myClass148Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass148>(q.getResultList());	
	}

	
	public MyClass148 findById (Long id) 
	{
		return this.entityManager.find (MyClass148.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass148 save (MyClass148 myclass148) 
	{
		if (myclass148.getId() != null) {
			return this.entityManager.merge(myclass148);
		} else {
			this.entityManager.persist(myclass148);
			return myclass148;
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
