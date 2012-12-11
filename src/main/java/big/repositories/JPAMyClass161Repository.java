package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass161Criteria;
import big.domain.MyClass161;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass161Repository")
public class JPAMyClass161Repository implements MyClass161Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass161> findAll () 
	{
		final String hql = "select e from MyClass161 e order by id";
		TypedQuery<MyClass161> query =
			this.entityManager.createQuery(hql, MyClass161.class);
		return query.getResultList();	
	}

	
	public List<MyClass161> findByCriteria (MyClass161Criteria myClass161Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass161> c = cb.createQuery(MyClass161.class);
		javax.persistence.criteria.Root<MyClass161> emp = c.from(MyClass161.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass161Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass161> q = this.entityManager.createQuery(c);
		
		if (myClass161Criteria.getId()!=null ){
			q.setParameter("id", myClass161Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass161>(q.getResultList());	
	}

	
	public MyClass161 findById (Long id) 
	{
		return this.entityManager.find (MyClass161.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass161 save (MyClass161 myclass161) 
	{
		if (myclass161.getId() != null) {
			return this.entityManager.merge(myclass161);
		} else {
			this.entityManager.persist(myclass161);
			return myclass161;
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
