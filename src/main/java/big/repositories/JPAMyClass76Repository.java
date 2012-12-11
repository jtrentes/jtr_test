package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass76Criteria;
import big.domain.MyClass76;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass76Repository")
public class JPAMyClass76Repository implements MyClass76Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass76> findAll () 
	{
		final String hql = "select e from MyClass76 e order by id";
		TypedQuery<MyClass76> query =
			this.entityManager.createQuery(hql, MyClass76.class);
		return query.getResultList();	
	}

	
	public List<MyClass76> findByCriteria (MyClass76Criteria myClass76Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass76> c = cb.createQuery(MyClass76.class);
		javax.persistence.criteria.Root<MyClass76> emp = c.from(MyClass76.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass76Criteria.getAttribute()!=null && !myClass76Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass76Criteria.getAttribute2()!=null && !myClass76Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass76Criteria.getAttribute3()!=null && !myClass76Criteria.getAttribute3().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute3");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute3");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass76Criteria.getAttribute4()!=null && !myClass76Criteria.getAttribute4().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute4");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute4");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass76Criteria.getAttribute5()!=null && !myClass76Criteria.getAttribute5().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute5");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute5");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass76Criteria.getAttribute6()!=null && !myClass76Criteria.getAttribute6().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute6");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute6");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass76Criteria.getAttribute7()!=null && !myClass76Criteria.getAttribute7().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute7");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute7");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass76Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass76Criteria.getMyclass89()!=null && myClass76Criteria.getMyclass89().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass89> val = cb.parameter(big.domain.MyClass89.class, "myclass89");	
			criteria.add(cb.equal(emp.get("myclass89"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass76> q = this.entityManager.createQuery(c);
		
		if (myClass76Criteria.getAttribute()!=null && !myClass76Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass76Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass76Criteria.getAttribute2()!=null && !myClass76Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass76Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass76Criteria.getAttribute3()!=null && !myClass76Criteria.getAttribute3().isEmpty()){
			q.setParameter("attribute3", myClass76Criteria.getAttribute3().replace("*","%").replace("?","_"));
		}
		if (myClass76Criteria.getAttribute4()!=null && !myClass76Criteria.getAttribute4().isEmpty()){
			q.setParameter("attribute4", myClass76Criteria.getAttribute4().replace("*","%").replace("?","_"));
		}
		if (myClass76Criteria.getAttribute5()!=null && !myClass76Criteria.getAttribute5().isEmpty()){
			q.setParameter("attribute5", myClass76Criteria.getAttribute5().replace("*","%").replace("?","_"));
		}
		if (myClass76Criteria.getAttribute6()!=null && !myClass76Criteria.getAttribute6().isEmpty()){
			q.setParameter("attribute6", myClass76Criteria.getAttribute6().replace("*","%").replace("?","_"));
		}
		if (myClass76Criteria.getAttribute7()!=null && !myClass76Criteria.getAttribute7().isEmpty()){
			q.setParameter("attribute7", myClass76Criteria.getAttribute7().replace("*","%").replace("?","_"));
		}
		if (myClass76Criteria.getId()!=null ){
			q.setParameter("id", myClass76Criteria.getId());
		}
		if (myClass76Criteria.getMyclass89()!=null && myClass76Criteria.getMyclass89().getId() > 0 ){
			q.setParameter("myclass89", myClass76Criteria.getMyclass89());
		}
		    
		return new java.util.ArrayList<MyClass76>(q.getResultList());	
	}

	
	public MyClass76 findById (Long id) 
	{
		return this.entityManager.find (MyClass76.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass76 save (MyClass76 myclass76) 
	{
		if (myclass76.getId() != null) {
			return this.entityManager.merge(myclass76);
		} else {
			this.entityManager.persist(myclass76);
			return myclass76;
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
