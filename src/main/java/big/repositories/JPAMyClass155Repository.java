package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.domain.MyClass155;
import java.util.List;
import big.repositories.criteria.MyClass155Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass155Repository")
public class JPAMyClass155Repository implements MyClass155Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass155> findAll () 
	{
		final String hql = "select e from MyClass155 e order by id";
		TypedQuery<MyClass155> query =
			this.entityManager.createQuery(hql, MyClass155.class);
		return query.getResultList();	
	}

	
	public List<MyClass155> findByCriteria (MyClass155Criteria myClass155Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass155> c = cb.createQuery(MyClass155.class);
		javax.persistence.criteria.Root<MyClass155> emp = c.from(MyClass155.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass155Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass155Criteria.getMyclass39()!=null && myClass155Criteria.getMyclass39().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass39> val = cb.parameter(big.domain.MyClass39.class, "myclass39");	
			criteria.add(cb.equal(emp.get("myclass39"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass155> q = this.entityManager.createQuery(c);
		
		if (myClass155Criteria.getId()!=null ){
			q.setParameter("id", myClass155Criteria.getId());
		}
		if (myClass155Criteria.getMyclass39()!=null && myClass155Criteria.getMyclass39().getId() > 0 ){
			q.setParameter("myclass39", myClass155Criteria.getMyclass39());
		}
		    
		return new java.util.ArrayList<MyClass155>(q.getResultList());	
	}

	
	public MyClass155 findById (Long id) 
	{
		return this.entityManager.find (MyClass155.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass155 save (MyClass155 myclass155) 
	{
		if (myclass155.getId() != null) {
			return this.entityManager.merge(myclass155);
		} else {
			this.entityManager.persist(myclass155);
			return myclass155;
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
