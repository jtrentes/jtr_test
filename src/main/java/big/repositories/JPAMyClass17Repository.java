package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass17;
import javax.persistence.EntityManager;
import java.util.List;
import big.repositories.criteria.MyClass17Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass17Repository")
public class JPAMyClass17Repository implements MyClass17Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass17> findAll () 
	{
		final String hql = "select e from MyClass17 e order by id";
		TypedQuery<MyClass17> query =
			this.entityManager.createQuery(hql, MyClass17.class);
		return query.getResultList();	
	}

	
	public List<MyClass17> findByCriteria (MyClass17Criteria myClass17Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass17> c = cb.createQuery(MyClass17.class);
		javax.persistence.criteria.Root<MyClass17> emp = c.from(MyClass17.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass17Criteria.getAttribute()!=null && !myClass17Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass17Criteria.getAttribute2()!=null && !myClass17Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass17Criteria.getAttribute3()!=null && !myClass17Criteria.getAttribute3().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute3");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute3");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass17Criteria.getAttribute4()!=null && !myClass17Criteria.getAttribute4().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute4");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute4");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass17Criteria.getAttribute5()!=null && !myClass17Criteria.getAttribute5().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute5");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute5");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass17Criteria.getAttribute6()!=null && !myClass17Criteria.getAttribute6().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute6");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute6");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass17Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass17Criteria.getMyclass76()!=null && myClass17Criteria.getMyclass76().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass76> val = cb.parameter(big.domain.MyClass76.class, "myclass76");	
			criteria.add(cb.equal(emp.get("myclass76"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass17> q = this.entityManager.createQuery(c);
		
		if (myClass17Criteria.getAttribute()!=null && !myClass17Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass17Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass17Criteria.getAttribute2()!=null && !myClass17Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass17Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass17Criteria.getAttribute3()!=null && !myClass17Criteria.getAttribute3().isEmpty()){
			q.setParameter("attribute3", myClass17Criteria.getAttribute3().replace("*","%").replace("?","_"));
		}
		if (myClass17Criteria.getAttribute4()!=null && !myClass17Criteria.getAttribute4().isEmpty()){
			q.setParameter("attribute4", myClass17Criteria.getAttribute4().replace("*","%").replace("?","_"));
		}
		if (myClass17Criteria.getAttribute5()!=null && !myClass17Criteria.getAttribute5().isEmpty()){
			q.setParameter("attribute5", myClass17Criteria.getAttribute5().replace("*","%").replace("?","_"));
		}
		if (myClass17Criteria.getAttribute6()!=null && !myClass17Criteria.getAttribute6().isEmpty()){
			q.setParameter("attribute6", myClass17Criteria.getAttribute6().replace("*","%").replace("?","_"));
		}
		if (myClass17Criteria.getId()!=null ){
			q.setParameter("id", myClass17Criteria.getId());
		}
		if (myClass17Criteria.getMyclass76()!=null && myClass17Criteria.getMyclass76().getId() > 0 ){
			q.setParameter("myclass76", myClass17Criteria.getMyclass76());
		}
		    
		return new java.util.ArrayList<MyClass17>(q.getResultList());	
	}

	
	public MyClass17 findById (Long id) 
	{
		return this.entityManager.find (MyClass17.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass17 save (MyClass17 myclass17) 
	{
		if (myclass17.getId() != null) {
			return this.entityManager.merge(myclass17);
		} else {
			this.entityManager.persist(myclass17);
			return myclass17;
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
