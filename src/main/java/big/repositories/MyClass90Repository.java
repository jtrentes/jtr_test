package big.repositories;

import big.domain.MyClass90;
import big.repositories.criteria.MyClass90Criteria;
import java.util.List;



public interface MyClass90Repository 
{

	public List<MyClass90> findAll () ;
	public List<MyClass90> findByCriteria (MyClass90Criteria myClass90Criteria) ;
	public MyClass90 findById (Long id) ;
	public MyClass90 save (MyClass90 myclass90) ;

}
