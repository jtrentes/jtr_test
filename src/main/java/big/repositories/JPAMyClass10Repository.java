package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass10Criteria;
import big.domain.MyClass10;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass10Repository")
public class JPAMyClass10Repository implements MyClass10Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass10> findAll () 
	{
		final String hql = "select e from MyClass10 e order by id";
		TypedQuery<MyClass10> query =
			this.entityManager.createQuery(hql, MyClass10.class);
		return query.getResultList();	
	}

	
	public List<MyClass10> findByCriteria (MyClass10Criteria myClass10Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass10> c = cb.createQuery(MyClass10.class);
		javax.persistence.criteria.Root<MyClass10> emp = c.from(MyClass10.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass10Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass10> q = this.entityManager.createQuery(c);
		
		if (myClass10Criteria.getId()!=null ){
			q.setParameter("id", myClass10Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass10>(q.getResultList());	
	}

	
	public MyClass10 findById (Long id) 
	{
		return this.entityManager.find (MyClass10.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass10 save (MyClass10 myclass10) 
	{
		if (myclass10.getId() != null) {
			return this.entityManager.merge(myclass10);
		} else {
			this.entityManager.persist(myclass10);
			return myclass10;
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
