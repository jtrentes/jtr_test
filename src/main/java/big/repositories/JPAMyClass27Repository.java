package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass27Criteria;
import big.domain.MyClass27;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass27Repository")
public class JPAMyClass27Repository implements MyClass27Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass27> findAll () 
	{
		final String hql = "select e from MyClass27 e order by id";
		TypedQuery<MyClass27> query =
			this.entityManager.createQuery(hql, MyClass27.class);
		return query.getResultList();	
	}

	
	public List<MyClass27> findByCriteria (MyClass27Criteria myClass27Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass27> c = cb.createQuery(MyClass27.class);
		javax.persistence.criteria.Root<MyClass27> emp = c.from(MyClass27.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass27Criteria.getAttribute()!=null && !myClass27Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass27Criteria.getAttribute2()!=null && !myClass27Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass27Criteria.getAttribute3()!=null && !myClass27Criteria.getAttribute3().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute3");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute3");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass27Criteria.getAttribute4()!=null && !myClass27Criteria.getAttribute4().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute4");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute4");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass27Criteria.getAttribute5()!=null && !myClass27Criteria.getAttribute5().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute5");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute5");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass27Criteria.getAttribute6()!=null && !myClass27Criteria.getAttribute6().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute6");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute6");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass27Criteria.getAttribute7()!=null && !myClass27Criteria.getAttribute7().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute7");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute7");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass27Criteria.getAttribute8()!=null && !myClass27Criteria.getAttribute8().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute8");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute8");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass27Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass27Criteria.getMyclass24()!=null && myClass27Criteria.getMyclass24().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass24> val = cb.parameter(big.domain.MyClass24.class, "myclass24");	
			criteria.add(cb.equal(emp.get("myclass24"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass27> q = this.entityManager.createQuery(c);
		
		if (myClass27Criteria.getAttribute()!=null && !myClass27Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass27Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass27Criteria.getAttribute2()!=null && !myClass27Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass27Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass27Criteria.getAttribute3()!=null && !myClass27Criteria.getAttribute3().isEmpty()){
			q.setParameter("attribute3", myClass27Criteria.getAttribute3().replace("*","%").replace("?","_"));
		}
		if (myClass27Criteria.getAttribute4()!=null && !myClass27Criteria.getAttribute4().isEmpty()){
			q.setParameter("attribute4", myClass27Criteria.getAttribute4().replace("*","%").replace("?","_"));
		}
		if (myClass27Criteria.getAttribute5()!=null && !myClass27Criteria.getAttribute5().isEmpty()){
			q.setParameter("attribute5", myClass27Criteria.getAttribute5().replace("*","%").replace("?","_"));
		}
		if (myClass27Criteria.getAttribute6()!=null && !myClass27Criteria.getAttribute6().isEmpty()){
			q.setParameter("attribute6", myClass27Criteria.getAttribute6().replace("*","%").replace("?","_"));
		}
		if (myClass27Criteria.getAttribute7()!=null && !myClass27Criteria.getAttribute7().isEmpty()){
			q.setParameter("attribute7", myClass27Criteria.getAttribute7().replace("*","%").replace("?","_"));
		}
		if (myClass27Criteria.getAttribute8()!=null && !myClass27Criteria.getAttribute8().isEmpty()){
			q.setParameter("attribute8", myClass27Criteria.getAttribute8().replace("*","%").replace("?","_"));
		}
		if (myClass27Criteria.getId()!=null ){
			q.setParameter("id", myClass27Criteria.getId());
		}
		if (myClass27Criteria.getMyclass24()!=null && myClass27Criteria.getMyclass24().getId() > 0 ){
			q.setParameter("myclass24", myClass27Criteria.getMyclass24());
		}
		    
		return new java.util.ArrayList<MyClass27>(q.getResultList());	
	}

	
	public MyClass27 findById (Long id) 
	{
		return this.entityManager.find (MyClass27.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass27 save (MyClass27 myclass27) 
	{
		if (myclass27.getId() != null) {
			return this.entityManager.merge(myclass27);
		} else {
			this.entityManager.persist(myclass27);
			return myclass27;
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
