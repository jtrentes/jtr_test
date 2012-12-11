package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass89Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import big.domain.MyClass89;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass89Repository")
public class JPAMyClass89Repository implements MyClass89Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass89> findAll () 
	{
		final String hql = "select e from MyClass89 e order by id";
		TypedQuery<MyClass89> query =
			this.entityManager.createQuery(hql, MyClass89.class);
		return query.getResultList();	
	}

	
	public List<MyClass89> findByCriteria (MyClass89Criteria myClass89Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass89> c = cb.createQuery(MyClass89.class);
		javax.persistence.criteria.Root<MyClass89> emp = c.from(MyClass89.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass89Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass89Criteria.getMyclass124()!=null && myClass89Criteria.getMyclass124().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass124> val = cb.parameter(big.domain.MyClass124.class, "myclass124");	
			criteria.add(cb.equal(emp.get("myclass124"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass89> q = this.entityManager.createQuery(c);
		
		if (myClass89Criteria.getId()!=null ){
			q.setParameter("id", myClass89Criteria.getId());
		}
		if (myClass89Criteria.getMyclass124()!=null && myClass89Criteria.getMyclass124().getId() > 0 ){
			q.setParameter("myclass124", myClass89Criteria.getMyclass124());
		}
		    
		return new java.util.ArrayList<MyClass89>(q.getResultList());	
	}

	
	public MyClass89 findById (Long id) 
	{
		return this.entityManager.find (MyClass89.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass89 save (MyClass89 myclass89) 
	{
		if (myclass89.getId() != null) {
			return this.entityManager.merge(myclass89);
		} else {
			this.entityManager.persist(myclass89);
			return myclass89;
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
