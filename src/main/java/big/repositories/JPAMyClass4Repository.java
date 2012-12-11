package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass4;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass4Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass4Repository")
public class JPAMyClass4Repository implements MyClass4Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass4> findAll () 
	{
		final String hql = "select e from MyClass4 e order by id";
		TypedQuery<MyClass4> query =
			this.entityManager.createQuery(hql, MyClass4.class);
		return query.getResultList();	
	}

	
	public List<MyClass4> findByCriteria (MyClass4Criteria myClass4Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass4> c = cb.createQuery(MyClass4.class);
		javax.persistence.criteria.Root<MyClass4> emp = c.from(MyClass4.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass4Criteria.getAttribute()!=null && !myClass4Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass4Criteria.getAttribute2()!=null && !myClass4Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass4Criteria.getAttribute3()!=null && !myClass4Criteria.getAttribute3().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute3");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute3");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass4Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass4Criteria.getMyclass()!=null && myClass4Criteria.getMyclass().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass> val = cb.parameter(big.domain.MyClass.class, "myclass");	
			criteria.add(cb.equal(emp.get("myclass"),val));
		}
		if (myClass4Criteria.getAttribute()!=null && !myClass4Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass4Criteria.getAttribute2()!=null && !myClass4Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass4Criteria.getAttribute3()!=null && !myClass4Criteria.getAttribute3().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute3");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute3");	
			criteria.add(cb.like(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass4> q = this.entityManager.createQuery(c);
		
		if (myClass4Criteria.getAttribute()!=null && !myClass4Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass4Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass4Criteria.getAttribute2()!=null && !myClass4Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass4Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass4Criteria.getAttribute3()!=null && !myClass4Criteria.getAttribute3().isEmpty()){
			q.setParameter("attribute3", myClass4Criteria.getAttribute3().replace("*","%").replace("?","_"));
		}
		if (myClass4Criteria.getId()!=null ){
			q.setParameter("id", myClass4Criteria.getId());
		}
		if (myClass4Criteria.getMyclass()!=null && myClass4Criteria.getMyclass().getId() > 0 ){
			q.setParameter("myclass", myClass4Criteria.getMyclass());
		}
		if (myClass4Criteria.getAttribute()!=null && !myClass4Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass4Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass4Criteria.getAttribute2()!=null && !myClass4Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass4Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass4Criteria.getAttribute3()!=null && !myClass4Criteria.getAttribute3().isEmpty()){
			q.setParameter("attribute3", myClass4Criteria.getAttribute3().replace("*","%").replace("?","_"));
		}
		    
		return new java.util.ArrayList<MyClass4>(q.getResultList());	
	}

	
	public MyClass4 findById (Long id) 
	{
		return this.entityManager.find (MyClass4.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass4 save (MyClass4 myclass4) 
	{
		if (myclass4.getId() != null) {
			return this.entityManager.merge(myclass4);
		} else {
			this.entityManager.persist(myclass4);
			return myclass4;
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
