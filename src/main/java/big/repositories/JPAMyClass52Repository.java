package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass52Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import big.domain.MyClass52;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass52Repository")
public class JPAMyClass52Repository implements MyClass52Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass52> findAll () 
	{
		final String hql = "select e from MyClass52 e order by id";
		TypedQuery<MyClass52> query =
			this.entityManager.createQuery(hql, MyClass52.class);
		return query.getResultList();	
	}

	
	public List<MyClass52> findByCriteria (MyClass52Criteria myClass52Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass52> c = cb.createQuery(MyClass52.class);
		javax.persistence.criteria.Root<MyClass52> emp = c.from(MyClass52.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass52Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass52> q = this.entityManager.createQuery(c);
		
		if (myClass52Criteria.getId()!=null ){
			q.setParameter("id", myClass52Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass52>(q.getResultList());	
	}

	
	public MyClass52 findById (Long id) 
	{
		return this.entityManager.find (MyClass52.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass52 save (MyClass52 myclass52) 
	{
		if (myclass52.getId() != null) {
			return this.entityManager.merge(myclass52);
		} else {
			this.entityManager.persist(myclass52);
			return myclass52;
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
