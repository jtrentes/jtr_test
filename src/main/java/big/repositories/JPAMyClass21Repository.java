package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass21;
import big.repositories.criteria.MyClass21Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass21Repository")
public class JPAMyClass21Repository implements MyClass21Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass21> findAll () 
	{
		final String hql = "select e from MyClass21 e order by id";
		TypedQuery<MyClass21> query =
			this.entityManager.createQuery(hql, MyClass21.class);
		return query.getResultList();	
	}

	
	public List<MyClass21> findByCriteria (MyClass21Criteria myClass21Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass21> c = cb.createQuery(MyClass21.class);
		javax.persistence.criteria.Root<MyClass21> emp = c.from(MyClass21.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass21Criteria.getAttribute()!=null && !myClass21Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass21Criteria.getAttribute2()!=null && !myClass21Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass21Criteria.getAttribute3()!=null && !myClass21Criteria.getAttribute3().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute3");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute3");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass21Criteria.getAttribute4()!=null && !myClass21Criteria.getAttribute4().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute4");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute4");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass21Criteria.getAttribute5()!=null && !myClass21Criteria.getAttribute5().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute5");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute5");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass21Criteria.getAttribute6()!=null && !myClass21Criteria.getAttribute6().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute6");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute6");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass21Criteria.getAttribute7()!=null && !myClass21Criteria.getAttribute7().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute7");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute7");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass21Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass21> q = this.entityManager.createQuery(c);
		
		if (myClass21Criteria.getAttribute()!=null && !myClass21Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass21Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass21Criteria.getAttribute2()!=null && !myClass21Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass21Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass21Criteria.getAttribute3()!=null && !myClass21Criteria.getAttribute3().isEmpty()){
			q.setParameter("attribute3", myClass21Criteria.getAttribute3().replace("*","%").replace("?","_"));
		}
		if (myClass21Criteria.getAttribute4()!=null && !myClass21Criteria.getAttribute4().isEmpty()){
			q.setParameter("attribute4", myClass21Criteria.getAttribute4().replace("*","%").replace("?","_"));
		}
		if (myClass21Criteria.getAttribute5()!=null && !myClass21Criteria.getAttribute5().isEmpty()){
			q.setParameter("attribute5", myClass21Criteria.getAttribute5().replace("*","%").replace("?","_"));
		}
		if (myClass21Criteria.getAttribute6()!=null && !myClass21Criteria.getAttribute6().isEmpty()){
			q.setParameter("attribute6", myClass21Criteria.getAttribute6().replace("*","%").replace("?","_"));
		}
		if (myClass21Criteria.getAttribute7()!=null && !myClass21Criteria.getAttribute7().isEmpty()){
			q.setParameter("attribute7", myClass21Criteria.getAttribute7().replace("*","%").replace("?","_"));
		}
		if (myClass21Criteria.getId()!=null ){
			q.setParameter("id", myClass21Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass21>(q.getResultList());	
	}

	
	public MyClass21 findById (Long id) 
	{
		return this.entityManager.find (MyClass21.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass21 save (MyClass21 myclass21) 
	{
		if (myclass21.getId() != null) {
			return this.entityManager.merge(myclass21);
		} else {
			this.entityManager.persist(myclass21);
			return myclass21;
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
