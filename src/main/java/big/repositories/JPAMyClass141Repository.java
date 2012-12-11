package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass141;
import big.repositories.criteria.MyClass141Criteria;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass141Repository")
public class JPAMyClass141Repository implements MyClass141Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass141> findAll () 
	{
		final String hql = "select e from MyClass141 e order by id";
		TypedQuery<MyClass141> query =
			this.entityManager.createQuery(hql, MyClass141.class);
		return query.getResultList();	
	}

	
	public List<MyClass141> findByCriteria (MyClass141Criteria myClass141Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass141> c = cb.createQuery(MyClass141.class);
		javax.persistence.criteria.Root<MyClass141> emp = c.from(MyClass141.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass141Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass141> q = this.entityManager.createQuery(c);
		
		if (myClass141Criteria.getId()!=null ){
			q.setParameter("id", myClass141Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass141>(q.getResultList());	
	}

	
	public MyClass141 findById (Long id) 
	{
		return this.entityManager.find (MyClass141.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass141 save (MyClass141 myclass141) 
	{
		if (myclass141.getId() != null) {
			return this.entityManager.merge(myclass141);
		} else {
			this.entityManager.persist(myclass141);
			return myclass141;
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
