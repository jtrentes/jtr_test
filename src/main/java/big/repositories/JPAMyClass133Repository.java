package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.repositories.criteria.MyClass133Criteria;
import big.domain.MyClass133;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;


@Repository(value = "myclass133Repository")
public class JPAMyClass133Repository implements MyClass133Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass133> findAll () 
	{
		final String hql = "select e from MyClass133 e order by id";
		TypedQuery<MyClass133> query =
			this.entityManager.createQuery(hql, MyClass133.class);
		return query.getResultList();	
	}

	
	public List<MyClass133> findByCriteria (MyClass133Criteria myClass133Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass133> c = cb.createQuery(MyClass133.class);
		javax.persistence.criteria.Root<MyClass133> emp = c.from(MyClass133.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass133Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass133Criteria.getMyclass5()!=null && myClass133Criteria.getMyclass5().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass5> val = cb.parameter(big.domain.MyClass5.class, "myclass5");	
			criteria.add(cb.equal(emp.get("myclass5"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass133> q = this.entityManager.createQuery(c);
		
		if (myClass133Criteria.getId()!=null ){
			q.setParameter("id", myClass133Criteria.getId());
		}
		if (myClass133Criteria.getMyclass5()!=null && myClass133Criteria.getMyclass5().getId() > 0 ){
			q.setParameter("myclass5", myClass133Criteria.getMyclass5());
		}
		    
		return new java.util.ArrayList<MyClass133>(q.getResultList());	
	}

	
	public MyClass133 findById (Long id) 
	{
		return this.entityManager.find (MyClass133.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass133 save (MyClass133 myclass133) 
	{
		if (myclass133.getId() != null) {
			return this.entityManager.merge(myclass133);
		} else {
			this.entityManager.persist(myclass133);
			return myclass133;
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
