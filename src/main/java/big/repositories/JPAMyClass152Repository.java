package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass152;
import big.repositories.criteria.MyClass152Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass152Repository")
public class JPAMyClass152Repository implements MyClass152Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass152> findAll () 
	{
		final String hql = "select e from MyClass152 e order by id";
		TypedQuery<MyClass152> query =
			this.entityManager.createQuery(hql, MyClass152.class);
		return query.getResultList();	
	}

	
	public List<MyClass152> findByCriteria (MyClass152Criteria myClass152Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass152> c = cb.createQuery(MyClass152.class);
		javax.persistence.criteria.Root<MyClass152> emp = c.from(MyClass152.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass152Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass152> q = this.entityManager.createQuery(c);
		
		if (myClass152Criteria.getId()!=null ){
			q.setParameter("id", myClass152Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass152>(q.getResultList());	
	}

	
	public MyClass152 findById (Long id) 
	{
		return this.entityManager.find (MyClass152.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass152 save (MyClass152 myclass152) 
	{
		if (myclass152.getId() != null) {
			return this.entityManager.merge(myclass152);
		} else {
			this.entityManager.persist(myclass152);
			return myclass152;
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
