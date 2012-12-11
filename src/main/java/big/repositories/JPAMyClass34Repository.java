package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass34Criteria;
import java.util.List;
import big.domain.MyClass34;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass34Repository")
public class JPAMyClass34Repository implements MyClass34Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass34> findAll () 
	{
		final String hql = "select e from MyClass34 e order by id";
		TypedQuery<MyClass34> query =
			this.entityManager.createQuery(hql, MyClass34.class);
		return query.getResultList();	
	}

	
	public List<MyClass34> findByCriteria (MyClass34Criteria myClass34Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass34> c = cb.createQuery(MyClass34.class);
		javax.persistence.criteria.Root<MyClass34> emp = c.from(MyClass34.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass34Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass34> q = this.entityManager.createQuery(c);
		
		if (myClass34Criteria.getId()!=null ){
			q.setParameter("id", myClass34Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass34>(q.getResultList());	
	}

	
	public MyClass34 findById (Long id) 
	{
		return this.entityManager.find (MyClass34.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass34 save (MyClass34 myclass34) 
	{
		if (myclass34.getId() != null) {
			return this.entityManager.merge(myclass34);
		} else {
			this.entityManager.persist(myclass34);
			return myclass34;
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
