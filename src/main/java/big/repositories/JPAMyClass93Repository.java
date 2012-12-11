package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass93Criteria;
import java.util.List;
import big.domain.MyClass93;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass93Repository")
public class JPAMyClass93Repository implements MyClass93Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass93> findAll () 
	{
		final String hql = "select e from MyClass93 e order by id";
		TypedQuery<MyClass93> query =
			this.entityManager.createQuery(hql, MyClass93.class);
		return query.getResultList();	
	}

	
	public List<MyClass93> findByCriteria (MyClass93Criteria myClass93Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass93> c = cb.createQuery(MyClass93.class);
		javax.persistence.criteria.Root<MyClass93> emp = c.from(MyClass93.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass93Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass93> q = this.entityManager.createQuery(c);
		
		if (myClass93Criteria.getId()!=null ){
			q.setParameter("id", myClass93Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass93>(q.getResultList());	
	}

	
	public MyClass93 findById (Long id) 
	{
		return this.entityManager.find (MyClass93.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass93 save (MyClass93 myclass93) 
	{
		if (myclass93.getId() != null) {
			return this.entityManager.merge(myclass93);
		} else {
			this.entityManager.persist(myclass93);
			return myclass93;
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
