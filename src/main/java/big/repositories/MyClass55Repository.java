package big.repositories;

import big.domain.MyClass55;
import java.util.List;
import big.repositories.criteria.MyClass55Criteria;



public interface MyClass55Repository 
{

	public List<MyClass55> findAll () ;
	public List<MyClass55> findByCriteria (MyClass55Criteria myClass55Criteria) ;
	public MyClass55 findById (Long id) ;
	public MyClass55 save (MyClass55 myclass55) ;

}
