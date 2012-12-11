package big.repositories;

import javax.persistence.TypedQuery;
import big.domain.MyClass131;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass131Criteria;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass131Repository")
public class JPAMyClass131Repository implements MyClass131Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass131> findAll () 
	{
		final String hql = "select e from MyClass131 e order by id";
		TypedQuery<MyClass131> query =
			this.entityManager.createQuery(hql, MyClass131.class);
		return query.getResultList();	
	}

	
	public List<MyClass131> findByCriteria (MyClass131Criteria myClass131Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass131> c = cb.createQuery(MyClass131.class);
		javax.persistence.criteria.Root<MyClass131> emp = c.from(MyClass131.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass131Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass131Criteria.getMyclass120()!=null && myClass131Criteria.getMyclass120().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass120> val = cb.parameter(big.domain.MyClass120.class, "myclass120");	
			criteria.add(cb.equal(emp.get("myclass120"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass131> q = this.entityManager.createQuery(c);
		
		if (myClass131Criteria.getId()!=null ){
			q.setParameter("id", myClass131Criteria.getId());
		}
		if (myClass131Criteria.getMyclass120()!=null && myClass131Criteria.getMyclass120().getId() > 0 ){
			q.setParameter("myclass120", myClass131Criteria.getMyclass120());
		}
		    
		return new java.util.ArrayList<MyClass131>(q.getResultList());	
	}

	
	public MyClass131 findById (Long id) 
	{
		return this.entityManager.find (MyClass131.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass131 save (MyClass131 myclass131) 
	{
		if (myclass131.getId() != null) {
			return this.entityManager.merge(myclass131);
		} else {
			this.entityManager.persist(myclass131);
			return myclass131;
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
