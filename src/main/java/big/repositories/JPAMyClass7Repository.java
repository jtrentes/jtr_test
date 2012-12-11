package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass7;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass7Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass7Repository")
public class JPAMyClass7Repository implements MyClass7Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass7> findAll () 
	{
		final String hql = "select e from MyClass7 e order by id";
		TypedQuery<MyClass7> query =
			this.entityManager.createQuery(hql, MyClass7.class);
		return query.getResultList();	
	}

	
	public List<MyClass7> findByCriteria (MyClass7Criteria myClass7Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass7> c = cb.createQuery(MyClass7.class);
		javax.persistence.criteria.Root<MyClass7> emp = c.from(MyClass7.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass7Criteria.getAttribute()!=null && !myClass7Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass7Criteria.getAttribute2()!=null && !myClass7Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass7Criteria.getAttribute3()!=null && !myClass7Criteria.getAttribute3().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute3");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute3");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass7Criteria.getAttribute4()!=null && !myClass7Criteria.getAttribute4().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute4");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute4");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass7Criteria.getAttribute5()!=null && !myClass7Criteria.getAttribute5().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute5");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute5");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass7Criteria.getAttribute6()!=null && !myClass7Criteria.getAttribute6().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute6");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute6");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass7Criteria.getAttribute7()!=null && !myClass7Criteria.getAttribute7().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute7");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute7");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass7Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass7Criteria.getMyclass69()!=null && myClass7Criteria.getMyclass69().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass69> val = cb.parameter(big.domain.MyClass69.class, "myclass69");	
			criteria.add(cb.equal(emp.get("myclass69"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass7> q = this.entityManager.createQuery(c);
		
		if (myClass7Criteria.getAttribute()!=null && !myClass7Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass7Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass7Criteria.getAttribute2()!=null && !myClass7Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass7Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass7Criteria.getAttribute3()!=null && !myClass7Criteria.getAttribute3().isEmpty()){
			q.setParameter("attribute3", myClass7Criteria.getAttribute3().replace("*","%").replace("?","_"));
		}
		if (myClass7Criteria.getAttribute4()!=null && !myClass7Criteria.getAttribute4().isEmpty()){
			q.setParameter("attribute4", myClass7Criteria.getAttribute4().replace("*","%").replace("?","_"));
		}
		if (myClass7Criteria.getAttribute5()!=null && !myClass7Criteria.getAttribute5().isEmpty()){
			q.setParameter("attribute5", myClass7Criteria.getAttribute5().replace("*","%").replace("?","_"));
		}
		if (myClass7Criteria.getAttribute6()!=null && !myClass7Criteria.getAttribute6().isEmpty()){
			q.setParameter("attribute6", myClass7Criteria.getAttribute6().replace("*","%").replace("?","_"));
		}
		if (myClass7Criteria.getAttribute7()!=null && !myClass7Criteria.getAttribute7().isEmpty()){
			q.setParameter("attribute7", myClass7Criteria.getAttribute7().replace("*","%").replace("?","_"));
		}
		if (myClass7Criteria.getId()!=null ){
			q.setParameter("id", myClass7Criteria.getId());
		}
		if (myClass7Criteria.getMyclass69()!=null && myClass7Criteria.getMyclass69().getId() > 0 ){
			q.setParameter("myclass69", myClass7Criteria.getMyclass69());
		}
		    
		return new java.util.ArrayList<MyClass7>(q.getResultList());	
	}

	
	public MyClass7 findById (Long id) 
	{
		return this.entityManager.find (MyClass7.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass7 save (MyClass7 myclass7) 
	{
		if (myclass7.getId() != null) {
			return this.entityManager.merge(myclass7);
		} else {
			this.entityManager.persist(myclass7);
			return myclass7;
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
