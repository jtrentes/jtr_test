package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass156Criteria;
import big.domain.MyClass156;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass156Repository")
public class JPAMyClass156Repository implements MyClass156Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass156> findAll () 
	{
		final String hql = "select e from MyClass156 e order by id";
		TypedQuery<MyClass156> query =
			this.entityManager.createQuery(hql, MyClass156.class);
		return query.getResultList();	
	}

	
	public List<MyClass156> findByCriteria (MyClass156Criteria myClass156Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass156> c = cb.createQuery(MyClass156.class);
		javax.persistence.criteria.Root<MyClass156> emp = c.from(MyClass156.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass156Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass156> q = this.entityManager.createQuery(c);
		
		if (myClass156Criteria.getId()!=null ){
			q.setParameter("id", myClass156Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass156>(q.getResultList());	
	}

	
	public MyClass156 findById (Long id) 
	{
		return this.entityManager.find (MyClass156.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass156 save (MyClass156 myclass156) 
	{
		if (myclass156.getId() != null) {
			return this.entityManager.merge(myclass156);
		} else {
			this.entityManager.persist(myclass156);
			return myclass156;
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
