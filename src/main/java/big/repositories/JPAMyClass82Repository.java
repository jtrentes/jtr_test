package big.repositories;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass82Criteria;
import big.domain.MyClass82;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass82Repository")
public class JPAMyClass82Repository implements MyClass82Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass82> findAll () 
	{
		final String hql = "select e from MyClass82 e order by id";
		TypedQuery<MyClass82> query =
			this.entityManager.createQuery(hql, MyClass82.class);
		return query.getResultList();	
	}

	
	public List<MyClass82> findByCriteria (MyClass82Criteria myClass82Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass82> c = cb.createQuery(MyClass82.class);
		javax.persistence.criteria.Root<MyClass82> emp = c.from(MyClass82.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass82Criteria.getAttribute()!=null && !myClass82Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute2()!=null && !myClass82Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute3()!=null && !myClass82Criteria.getAttribute3().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute3");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute3");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute4()!=null && !myClass82Criteria.getAttribute4().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute4");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute4");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute5()!=null && !myClass82Criteria.getAttribute5().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute5");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute5");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute6()!=null && !myClass82Criteria.getAttribute6().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute6");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute6");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute7()!=null && !myClass82Criteria.getAttribute7().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute7");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute7");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute8()!=null && !myClass82Criteria.getAttribute8().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute8");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute8");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute9()!=null && !myClass82Criteria.getAttribute9().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute9");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute9");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute10()!=null && !myClass82Criteria.getAttribute10().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute10");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute10");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute11()!=null && !myClass82Criteria.getAttribute11().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute11");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute11");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute12()!=null && !myClass82Criteria.getAttribute12().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute12");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute12");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute13()!=null && !myClass82Criteria.getAttribute13().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute13");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute13");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute14()!=null && !myClass82Criteria.getAttribute14().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute14");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute14");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute15()!=null && !myClass82Criteria.getAttribute15().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute15");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute15");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute16()!=null && !myClass82Criteria.getAttribute16().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute16");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute16");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute17()!=null && !myClass82Criteria.getAttribute17().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute17");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute17");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getAttribute18()!=null && !myClass82Criteria.getAttribute18().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute18");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute18");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass82Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass82> q = this.entityManager.createQuery(c);
		
		if (myClass82Criteria.getAttribute()!=null && !myClass82Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass82Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute2()!=null && !myClass82Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass82Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute3()!=null && !myClass82Criteria.getAttribute3().isEmpty()){
			q.setParameter("attribute3", myClass82Criteria.getAttribute3().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute4()!=null && !myClass82Criteria.getAttribute4().isEmpty()){
			q.setParameter("attribute4", myClass82Criteria.getAttribute4().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute5()!=null && !myClass82Criteria.getAttribute5().isEmpty()){
			q.setParameter("attribute5", myClass82Criteria.getAttribute5().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute6()!=null && !myClass82Criteria.getAttribute6().isEmpty()){
			q.setParameter("attribute6", myClass82Criteria.getAttribute6().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute7()!=null && !myClass82Criteria.getAttribute7().isEmpty()){
			q.setParameter("attribute7", myClass82Criteria.getAttribute7().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute8()!=null && !myClass82Criteria.getAttribute8().isEmpty()){
			q.setParameter("attribute8", myClass82Criteria.getAttribute8().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute9()!=null && !myClass82Criteria.getAttribute9().isEmpty()){
			q.setParameter("attribute9", myClass82Criteria.getAttribute9().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute10()!=null && !myClass82Criteria.getAttribute10().isEmpty()){
			q.setParameter("attribute10", myClass82Criteria.getAttribute10().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute11()!=null && !myClass82Criteria.getAttribute11().isEmpty()){
			q.setParameter("attribute11", myClass82Criteria.getAttribute11().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute12()!=null && !myClass82Criteria.getAttribute12().isEmpty()){
			q.setParameter("attribute12", myClass82Criteria.getAttribute12().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute13()!=null && !myClass82Criteria.getAttribute13().isEmpty()){
			q.setParameter("attribute13", myClass82Criteria.getAttribute13().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute14()!=null && !myClass82Criteria.getAttribute14().isEmpty()){
			q.setParameter("attribute14", myClass82Criteria.getAttribute14().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute15()!=null && !myClass82Criteria.getAttribute15().isEmpty()){
			q.setParameter("attribute15", myClass82Criteria.getAttribute15().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute16()!=null && !myClass82Criteria.getAttribute16().isEmpty()){
			q.setParameter("attribute16", myClass82Criteria.getAttribute16().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute17()!=null && !myClass82Criteria.getAttribute17().isEmpty()){
			q.setParameter("attribute17", myClass82Criteria.getAttribute17().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getAttribute18()!=null && !myClass82Criteria.getAttribute18().isEmpty()){
			q.setParameter("attribute18", myClass82Criteria.getAttribute18().replace("*","%").replace("?","_"));
		}
		if (myClass82Criteria.getId()!=null ){
			q.setParameter("id", myClass82Criteria.getId());
		}
		    
		return new java.util.ArrayList<MyClass82>(q.getResultList());	
	}

	
	public MyClass82 findById (Long id) 
	{
		return this.entityManager.find (MyClass82.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass82 save (MyClass82 myclass82) 
	{
		if (myclass82.getId() != null) {
			return this.entityManager.merge(myclass82);
		} else {
			this.entityManager.persist(myclass82);
			return myclass82;
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
