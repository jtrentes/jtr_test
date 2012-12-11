package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass127;
import big.repositories.criteria.MyClass127Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass127Repository")
public class JPAMyClass127Repository implements MyClass127Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass127> findAll () 
	{
		final String hql = "select e from MyClass127 e order by id";
		TypedQuery<MyClass127> query =
			this.entityManager.createQuery(hql, MyClass127.class);
		return query.getResultList();	
	}

	
	public List<MyClass127> findByCriteria (MyClass127Criteria myClass127Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass127> c = cb.createQuery(MyClass127.class);
		javax.persistence.criteria.Root<MyClass127> emp = c.from(MyClass127.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass127Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass127> q = this.entityManager.createQuery(c);
		
		if (myClass127Criteria.getId()!=null ){
			q.setParameter("id", myClass127Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass127>(q.getResultList());	
	}

	
	public MyClass127 findById (Long id) 
	{
		return this.entityManager.find (MyClass127.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass127 save (MyClass127 myclass127) 
	{
		if (myclass127.getId() != null) {
			return this.entityManager.merge(myclass127);
		} else {
			this.entityManager.persist(myclass127);
			return myclass127;
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
