package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.domain.MyClass2;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass2Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass2Repository")
public class JPAMyClass2Repository implements MyClass2Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass2> findAll () 
	{
		final String hql = "select e from MyClass2 e order by id";
		TypedQuery<MyClass2> query =
			this.entityManager.createQuery(hql, MyClass2.class);
		return query.getResultList();	
	}

	
	public List<MyClass2> findByCriteria (MyClass2Criteria myClass2Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass2> c = cb.createQuery(MyClass2.class);
		javax.persistence.criteria.Root<MyClass2> emp = c.from(MyClass2.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass2Criteria.getAttribute()!=null && !myClass2Criteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass2Criteria.getAttribute2()!=null && !myClass2Criteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass2Criteria.getAttribute3()!=null && !myClass2Criteria.getAttribute3().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute3");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute3");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClass2Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass2Criteria.getMyclass()!=null && myClass2Criteria.getMyclass().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass> val = cb.parameter(big.domain.MyClass.class, "myclass");	
			criteria.add(cb.equal(emp.get("myclass"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass2> q = this.entityManager.createQuery(c);
		
		if (myClass2Criteria.getAttribute()!=null && !myClass2Criteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClass2Criteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClass2Criteria.getAttribute2()!=null && !myClass2Criteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClass2Criteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClass2Criteria.getAttribute3()!=null && !myClass2Criteria.getAttribute3().isEmpty()){
			q.setParameter("attribute3", myClass2Criteria.getAttribute3().replace("*","%").replace("?","_"));
		}
		if (myClass2Criteria.getId()!=null ){
			q.setParameter("id", myClass2Criteria.getId());
		}
		if (myClass2Criteria.getMyclass()!=null && myClass2Criteria.getMyclass().getId() > 0 ){
			q.setParameter("myclass", myClass2Criteria.getMyclass());
		}
		    
		return new java.util.ArrayList<MyClass2>(q.getResultList());	
	}

	
	public MyClass2 findById (Long id) 
	{
		return this.entityManager.find (MyClass2.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass2 save (MyClass2 myclass2) 
	{
		if (myclass2.getId() != null) {
			return this.entityManager.merge(myclass2);
		} else {
			this.entityManager.persist(myclass2);
			return myclass2;
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
