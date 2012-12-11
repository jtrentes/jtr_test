package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass163;
import big.repositories.criteria.MyClass163Criteria;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass163Repository")
public class JPAMyClass163Repository implements MyClass163Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass163> findAll () 
	{
		final String hql = "select e from MyClass163 e order by id";
		TypedQuery<MyClass163> query =
			this.entityManager.createQuery(hql, MyClass163.class);
		return query.getResultList();	
	}

	
	public List<MyClass163> findByCriteria (MyClass163Criteria myClass163Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass163> c = cb.createQuery(MyClass163.class);
		javax.persistence.criteria.Root<MyClass163> emp = c.from(MyClass163.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass163Criteria.getAttribute()!=null && !myClass163Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass163Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass163Criteria.getMyclass28()!=null && myClass163Criteria.getMyclass28().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass28> val = cb.parameter(big.domain.MyClass28.class, "myclass28");	
			criteria.add(cb.equal(emp.get("myclass28"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass163> q = this.entityManager.createQuery(c);
		
		if (myClass163Criteria.getAttribute()!=null && !myClass163Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass163Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass163Criteria.getId()!=null ){
			q.setParameter("id", myClass163Criteria.getId());
		}
		if (myClass163Criteria.getMyclass28()!=null && myClass163Criteria.getMyclass28().getId() > 0 ){
			q.setParameter("myclass28", myClass163Criteria.getMyclass28());
		}
		    
		return new java.util.ArrayList<MyClass163>(q.getResultList());	
	}

	
	public MyClass163 findById (Long id) 
	{
		return this.entityManager.find (MyClass163.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass163 save (MyClass163 myclass163) 
	{
		if (myclass163.getId() != null) {
			return this.entityManager.merge(myclass163);
		} else {
			this.entityManager.persist(myclass163);
			return myclass163;
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
