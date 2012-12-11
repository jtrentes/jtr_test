package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClassCriteria;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclassRepository")
public class JPAMyClassRepository implements MyClassRepository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass> findAll () 
	{
		final String hql = "select e from MyClass e order by id";
		TypedQuery<MyClass> query =
			this.entityManager.createQuery(hql, MyClass.class);
		return query.getResultList();	
	}

	
	public List<MyClass> findByCriteria (MyClassCriteria myClassCriteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass> c = cb.createQuery(MyClass.class);
		javax.persistence.criteria.Root<MyClass> emp = c.from(MyClass.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClassCriteria.getAttribute()!=null && !myClassCriteria.getAttribute().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClassCriteria.getAttribute2()!=null && !myClassCriteria.getAttribute2().isEmpty()){
			javax.persistence.criteria.Expression<String> p =  emp.get("attribute2");
			javax.persistence.criteria.Expression<String> val = cb.parameter(String.class, "attribute2");	
			criteria.add(cb.like(p,val));
		
		}
		if (myClassCriteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClassCriteria.getMyclass2()!=null && myClassCriteria.getMyclass2().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass2> val = cb.parameter(big.domain.MyClass2.class, "myclass2");	
			criteria.add(cb.equal(emp.get("myclass2"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass> q = this.entityManager.createQuery(c);
		
		if (myClassCriteria.getAttribute()!=null && !myClassCriteria.getAttribute().isEmpty()){
			q.setParameter("attribute", myClassCriteria.getAttribute().replace("*","%").replace("?","_"));
		}
		if (myClassCriteria.getAttribute2()!=null && !myClassCriteria.getAttribute2().isEmpty()){
			q.setParameter("attribute2", myClassCriteria.getAttribute2().replace("*","%").replace("?","_"));
		}
		if (myClassCriteria.getId()!=null ){
			q.setParameter("id", myClassCriteria.getId());
		}
		if (myClassCriteria.getMyclass2()!=null && myClassCriteria.getMyclass2().getId() > 0 ){
			q.setParameter("myclass2", myClassCriteria.getMyclass2());
		}
		    
		return new java.util.ArrayList<MyClass>(q.getResultList());	
	}

	
	public MyClass findById (Long id) 
	{
		return this.entityManager.find (MyClass.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass save (MyClass myclass) 
	{
		if (myclass.getId() != null) {
			return this.entityManager.merge(myclass);
		} else {
			this.entityManager.persist(myclass);
			return myclass;
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
