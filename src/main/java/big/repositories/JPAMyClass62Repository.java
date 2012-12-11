package big.repositories;

import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import big.domain.MyClass62;
import big.repositories.criteria.MyClass62Criteria;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository(value = "myclass62Repository")
public class JPAMyClass62Repository implements MyClass62Repository
{

	
	@PersistenceContext
	private EntityManager entityManager;
    

	
	public List<MyClass62> findAll () 
	{
		final String hql = "select e from MyClass62 e order by id";
		TypedQuery<MyClass62> query =
			this.entityManager.createQuery(hql, MyClass62.class);
		return query.getResultList();	
	}

	
	public List<MyClass62> findByCriteria (MyClass62Criteria myClass62Criteria) 
	{
		javax.persistence.criteria.CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<MyClass62> c = cb.createQuery(MyClass62.class);
		javax.persistence.criteria.Root<MyClass62> emp = c.from(MyClass62.class);
		c.select(emp);
		
		List<javax.persistence.criteria.Predicate> criteria =
		    new java.util.ArrayList<javax.persistence.criteria.Predicate>();
		    
		if (myClass62Criteria.getId()!=null ){
			javax.persistence.criteria.Expression<Long> p =  emp.get("id");
			javax.persistence.criteria.Expression<Long> val = cb.parameter(Long.class, "id");	
			criteria.add(cb.equal(p,val));
		
		}
		if (myClass62Criteria.getMyclass63()!=null && myClass62Criteria.getMyclass63().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass63> val = cb.parameter(big.domain.MyClass63.class, "myclass63");	
			criteria.add(cb.equal(emp.get("myclass63"),val));
		}
		if (myClass62Criteria.getMyclass35()!=null && myClass62Criteria.getMyclass35().getId() > 0 ){
			javax.persistence.criteria.Expression<big.domain.MyClass35> val = cb.parameter(big.domain.MyClass35.class, "myclass35");	
			criteria.add(cb.equal(emp.get("myclass35"),val));
		}
		   
		
		if (criteria.size()==1) {
			c.where(criteria.get(0));
		}else {
			c.where(cb.and(criteria.toArray(new javax.persistence.criteria.Predicate[0])));
		}		 
		javax.persistence.TypedQuery<MyClass62> q = this.entityManager.createQuery(c);
		
		if (myClass62Criteria.getId()!=null ){
			q.setParameter("id", myClass62Criteria.getId());
		}
		if (myClass62Criteria.getMyclass63()!=null && myClass62Criteria.getMyclass63().getId() > 0 ){
			q.setParameter("myclass63", myClass62Criteria.getMyclass63());
		}
		if (myClass62Criteria.getMyclass35()!=null && myClass62Criteria.getMyclass35().getId() > 0 ){
			q.setParameter("myclass35", myClass62Criteria.getMyclass35());
		}
		    
		return new java.util.ArrayList<MyClass62>(q.getResultList());	
	}

	
	public MyClass62 findById (Long id) 
	{
		return this.entityManager.find (MyClass62.class, id);	
	}

	
	public EntityManager getEntityManager () 
	{
		return this.entityManager;	
	}

	
	public MyClass62 save (MyClass62 myclass62) 
	{
		if (myclass62.getId() != null) {
			return this.entityManager.merge(myclass62);
		} else {
			this.entityManager.persist(myclass62);
			return myclass62;
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
