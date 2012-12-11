package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass116Criteria;
import big.domain.MyClass116;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass116Repository")
public class JPAMyClass116Repository implements MyClass116Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass116> findAll () 
	{
		final String hql = "select e from MyClass116 e order by id";
		TypedQuery<MyClass116> query =
			this.entityManager.createQuery(hql, MyClass116.class);
		return query.getResultList();	
	}

	
	public List<MyClass116> findByCriteria (MyClass116Criteria myClass116Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass116> c = cb.createQuery(MyClass116.class);
		javax.persistence.criteria.Root<MyClass116> emp = c.from(MyClass116.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass116Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass116> q = this.entityManager.createQuery(c);
		
		if (myClass116Criteria.getId()!=null ){
			q.setParameter("id", myClass116Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass116>(q.getResultList());	
	}

	
	public MyClass116 findById (Long id) 
	{
		return this.entityManager.find (MyClass116.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass116 save (MyClass116 myclass116) 
	{
		if (myclass116.getId() != null) {
			return this.entityManager.merge(myclass116);
		} else {
			this.entityManager.persist(myclass116);
			return myclass116;
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
