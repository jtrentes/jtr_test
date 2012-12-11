package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.domain.MyClass22;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass22Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass22Repository")
public class JPAMyClass22Repository implements MyClass22Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass22> findAll () 
	{
		final String hql = "select e from MyClass22 e order by id";
		TypedQuery<MyClass22> query =
			this.entityManager.createQuery(hql, MyClass22.class);
		return query.getResultList();	
	}

	
	public List<MyClass22> findByCriteria (MyClass22Criteria myClass22Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass22> c = cb.createQuery(MyClass22.class);
		javax.persistence.criteria.Root<MyClass22> emp = c.from(MyClass22.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass22Criteria.getAttribute()!=null && !myClass22Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass22Criteria.getAttribute2()!=null && !myClass22Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass22Criteria.getAttribute3()!=null && !myClass22Criteria.getAttribute3().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute3");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute3");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass22Criteria.getAttribute4()!=null && !myClass22Criteria.getAttribute4().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute4");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute4");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass22Criteria.getAttribute5()!=null && !myClass22Criteria.getAttribute5().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute5");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute5");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass22Criteria.getAttribute6()!=null && !myClass22Criteria.getAttribute6().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute6");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute6");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass22Criteria.getAttribute7()!=null && !myClass22Criteria.getAttribute7().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute7");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute7");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass22Criteria.getAttribute8()!=null && !myClass22Criteria.getAttribute8().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute8");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute8");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass22Criteria.getAttribute9()!=null && !myClass22Criteria.getAttribute9().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute9");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute9");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass22Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass22> q = this.entityManager.createQuery(c);
		
		if (myClass22Criteria.getAttribute()!=null && !myClass22Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass22Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass22Criteria.getAttribute2()!=null && !myClass22Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass22Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass22Criteria.getAttribute3()!=null && !myClass22Criteria.getAttribute3().isEmpty()){
			q.setParameter("attribute3", myClass22Criteria.getAttribute3().replace("*","%").replace("?","_"));
		}
		if (myClass22Criteria.getAttribute4()!=null && !myClass22Criteria.getAttribute4().isEmpty()){
			q.setParameter("attribute4", myClass22Criteria.getAttribute4().replace("*","%").replace("?","_"));
		}
		if (myClass22Criteria.getAttribute5()!=null && !myClass22Criteria.getAttribute5().isEmpty()){
			q.setParameter("attribute5", myClass22Criteria.getAttribute5().replace("*","%").replace("?","_"));
		}
		if (myClass22Criteria.getAttribute6()!=null && !myClass22Criteria.getAttribute6().isEmpty()){
			q.setParameter("attribute6", myClass22Criteria.getAttribute6().replace("*","%").replace("?","_"));
		}
		if (myClass22Criteria.getAttribute7()!=null && !myClass22Criteria.getAttribute7().isEmpty()){
			q.setParameter("attribute7", myClass22Criteria.getAttribute7().replace("*","%").replace("?","_"));
		}
		if (myClass22Criteria.getAttribute8()!=null && !myClass22Criteria.getAttribute8().isEmpty()){
			q.setParameter("attribute8", myClass22Criteria.getAttribute8().replace("*","%").replace("?","_"));
		}
		if (myClass22Criteria.getAttribute9()!=null && !myClass22Criteria.getAttribute9().isEmpty()){
			q.setParameter("attribute9", myClass22Criteria.getAttribute9().replace("*","%").replace("?","_"));
		}
		if (myClass22Criteria.getId()!=null ){
			q.setParameter("id", myClass22Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass22>(q.getResultList());	
	}

	
	public MyClass22 findById (Long id) 
	{
		return this.entityManager.find (MyClass22.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass22 save (MyClass22 myclass22) 
	{
		if (myclass22.getId() != null) {
			return this.entityManager.merge(myclass22);
		} else {
			this.entityManager.persist(myclass22);
			return myclass22;
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
