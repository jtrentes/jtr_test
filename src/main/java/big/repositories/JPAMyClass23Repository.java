package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass23Criteria;
import big.domain.MyClass23;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass23Repository")
public class JPAMyClass23Repository implements MyClass23Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass23> findAll () 
	{
		final String hql = "select e from MyClass23 e order by id";
		TypedQuery<MyClass23> query =
			this.entityManager.createQuery(hql, MyClass23.class);
		return query.getResultList();	
	}

	
	public List<MyClass23> findByCriteria (MyClass23Criteria myClass23Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass23> c = cb.createQuery(MyClass23.class);
		javax.persistence.criteria.Root<MyClass23> emp = c.from(MyClass23.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass23Criteria.getAttribute()!=null && !myClass23Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass23Criteria.getAttribute2()!=null && !myClass23Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass23Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass23Criteria.getMyclass28()!=null && myClass23Criteria.getMyclass28().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass28> val = cb.parameter(big.domain.MyClass28.class, "myclass28");	
			criteria.add(cb.equal(emp.get("myclass28"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass23> q = this.entityManager.createQuery(c);
		
		if (myClass23Criteria.getAttribute()!=null && !myClass23Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass23Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass23Criteria.getAttribute2()!=null && !myClass23Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass23Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass23Criteria.getId()!=null ){
			q.setParameter("id", myClass23Criteria.getId());
		}
		if (myClass23Criteria.getMyclass28()!=null && myClass23Criteria.getMyclass28().getId() > 0 ){
			q.setParameter("myclass28", myClass23Criteria.getMyclass28());
		}
		    
		return new java.util.ArrayList<MyClass23>(q.getResultList());	
	}

	
	public MyClass23 findById (Long id) 
	{
		return this.entityManager.find (MyClass23.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass23 save (MyClass23 myclass23) 
	{
		if (myclass23.getId() != null) {
			return this.entityManager.merge(myclass23);
		} else {
			this.entityManager.persist(myclass23);
			return myclass23;
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
