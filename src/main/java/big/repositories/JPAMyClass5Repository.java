package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import big.repositories.criteria.MyClass5Criteria;
import big.domain.MyClass5;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass5Repository")
public class JPAMyClass5Repository implements MyClass5Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass5> findAll () 
	{
		final String hql = "select e from MyClass5 e order by id";
		TypedQuery<MyClass5> query =
			this.entityManager.createQuery(hql, MyClass5.class);
		return query.getResultList();	
	}

	
	public List<MyClass5> findByCriteria (MyClass5Criteria myClass5Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass5> c = cb.createQuery(MyClass5.class);
		javax.persistence.criteria.Root<MyClass5> emp = c.from(MyClass5.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass5Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass5Criteria.getMyclass9()!=null && myClass5Criteria.getMyclass9().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass9> val = cb.parameter(big.domain.MyClass9.class, "myclass9");	
			criteria.add(cb.equal(emp.get("myclass9"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass5> q = this.entityManager.createQuery(c);
		
		if (myClass5Criteria.getId()!=null ){
			q.setParameter("id", myClass5Criteria.getId());
		}
		if (myClass5Criteria.getMyclass9()!=null && myClass5Criteria.getMyclass9().getId() > 0 ){
			q.setParameter("myclass9", myClass5Criteria.getMyclass9());
		}
		    
		return new java.util.ArrayList<MyClass5>(q.getResultList());	
	}

	
	public MyClass5 findById (Long id) 
	{
		return this.entityManager.find (MyClass5.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass5 save (MyClass5 myclass5) 
	{
		if (myclass5.getId() != null) {
			return this.entityManager.merge(myclass5);
		} else {
			this.entityManager.persist(myclass5);
			return myclass5;
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
