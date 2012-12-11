package big.repositories;

import javax.persistence.TypedQuery;
import big.repositories.criteria.MyClass9Criteria;
import big.domain.MyClass9;
import javax.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass9Repository")
public class JPAMyClass9Repository implements MyClass9Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass9> findAll () 
	{
		final String hql = "select e from MyClass9 e order by id";
		TypedQuery<MyClass9> query =
			this.entityManager.createQuery(hql, MyClass9.class);
		return query.getResultList();	
	}

	
	public List<MyClass9> findByCriteria (MyClass9Criteria myClass9Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass9> c = cb.createQuery(MyClass9.class);
		javax.persistence.criteria.Root<MyClass9> emp = c.from(MyClass9.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass9Criteria.getAttribute()!=null && !myClass9Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass9Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass9Criteria.getMyclass81()!=null && myClass9Criteria.getMyclass81().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass81> val = cb.parameter(big.domain.MyClass81.class, "myclass81");	
			criteria.add(cb.equal(emp.get("myclass81"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass9> q = this.entityManager.createQuery(c);
		
		if (myClass9Criteria.getAttribute()!=null && !myClass9Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass9Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass9Criteria.getId()!=null ){
			q.setParameter("id", myClass9Criteria.getId());
		}
		if (myClass9Criteria.getMyclass81()!=null && myClass9Criteria.getMyclass81().getId() > 0 ){
			q.setParameter("myclass81", myClass9Criteria.getMyclass81());
		}
		    
		return new java.util.ArrayList<MyClass9>(q.getResultList());	
	}

	
	public MyClass9 findById (Long id) 
	{
		return this.entityManager.find (MyClass9.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass9 save (MyClass9 myclass9) 
	{
		if (myclass9.getId() != null) {
			return this.entityManager.merge(myclass9);
		} else {
			this.entityManager.persist(myclass9);
			return myclass9;
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
