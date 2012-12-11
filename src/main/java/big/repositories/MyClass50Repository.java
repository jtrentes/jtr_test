package big.repositories;

import big.domain.MyClass50;
import java.util.List;
import big.repositories.criteria.MyClass50Criteria;



public interface MyClass50Repository 
{

	public List<MyClass50> findAll () ;
	public List<MyClass50> findByCriteria (MyClass50Criteria myClass50Criteria) ;
	public MyClass50 findById (Long id) ;
	public MyClass50 save (MyClass50 myclass50) ;

}
