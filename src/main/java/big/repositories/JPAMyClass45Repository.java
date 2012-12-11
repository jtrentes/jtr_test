package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass45;
import big.repositories.criteria.MyClass45Criteria;
import javax.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass45Repository")
public class JPAMyClass45Repository implements MyClass45Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass45> findAll () 
	{
		final String hql = "select e from MyClass45 e order by id";
		TypedQuery<MyClass45> query =
			this.entityManager.createQuery(hql, MyClass45.class);
		return query.getResultList();	
	}

	
	public List<MyClass45> findByCriteria (MyClass45Criteria myClass45Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass45> c = cb.createQuery(MyClass45.class);
		javax.persistence.criteria.Root<MyClass45> emp = c.from(MyClass45.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass45Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass45Criteria.getMyclass54()!=null && myClass45Criteria.getMyclass54().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass54> val = cb.parameter(big.domain.MyClass54.class, "myclass54");	
			criteria.add(cb.equal(emp.get("myclass54"),val));
		}
		if (myClass45Criteria.getMyclass46()!=null && myClass45Criteria.getMyclass46().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass46> val = cb.parameter(big.domain.MyClass46.class, "myclass46");	
			criteria.add(cb.equal(emp.get("myclass46"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass45> q = this.entityManager.createQuery(c);
		
		if (myClass45Criteria.getId()!=null ){
			q.setParameter("id", myClass45Criteria.getId());
		}
		if (myClass45Criteria.getMyclass54()!=null && myClass45Criteria.getMyclass54().getId() > 0 ){
			q.setParameter("myclass54", myClass45Criteria.getMyclass54());
		}
		if (myClass45Criteria.getMyclass46()!=null && myClass45Criteria.getMyclass46().getId() > 0 ){
			q.setParameter("myclass46", myClass45Criteria.getMyclass46());
		}
		    
		return new java.util.ArrayList<MyClass45>(q.getResultList());	
	}

	
	public MyClass45 findById (Long id) 
	{
		return this.entityManager.find (MyClass45.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass45 save (MyClass45 myclass45) 
	{
		if (myclass45.getId() != null) {
			return this.entityManager.merge(myclass45);
		} else {
			this.entityManager.persist(myclass45);
			return myclass45;
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
