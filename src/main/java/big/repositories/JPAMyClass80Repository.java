package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass80;
import big.repositories.criteria.MyClass80Criteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass80Repository")
public class JPAMyClass80Repository implements MyClass80Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass80> findAll () 
	{
		final String hql = "select e from MyClass80 e order by id";
		TypedQuery<MyClass80> query =
			this.entityManager.createQuery(hql, MyClass80.class);
		return query.getResultList();	
	}

	
	public List<MyClass80> findByCriteria (MyClass80Criteria myClass80Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass80> c = cb.createQuery(MyClass80.class);
		javax.persistence.criteria.Root<MyClass80> emp = c.from(MyClass80.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass80Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass80> q = this.entityManager.createQuery(c);
		
		if (myClass80Criteria.getId()!=null ){
			q.setParameter("id", myClass80Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass80>(q.getResultList());	
	}

	
	public MyClass80 findById (Long id) 
	{
		return this.entityManager.find (MyClass80.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass80 save (MyClass80 myclass80) 
	{
		if (myclass80.getId() != null) {
			return this.entityManager.merge(myclass80);
		} else {
			this.entityManager.persist(myclass80);
			return myclass80;
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
