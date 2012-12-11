package big.repositories;

import big.repositories.criteria.MyClass67Criteria;
import java.util.List;
import big.domain.MyClass67;



public interface MyClass67Repository 
{

	public List<MyClass67> findAll () ;
	public List<MyClass67> findByCriteria (MyClass67Criteria myClass67Criteria) ;
	public MyClass67 findById (Long id) ;
	public MyClass67 save (MyClass67 myclass67) ;

}
