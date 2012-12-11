package big.repositories;

import big.repositories.criteria.MyClass15Criteria;
import big.domain.MyClass15;
import java.util.List;



public interface MyClass15Repository 
{

	public List<MyClass15> findAll () ;
	public List<MyClass15> findByCriteria (MyClass15Criteria myClass15Criteria) ;
	public MyClass15 findById (Long id) ;
	public MyClass15 save (MyClass15 myclass15) ;

}
