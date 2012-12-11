package big.repositories;

import big.domain.MyClass101;
import java.util.List;
import big.repositories.criteria.MyClass101Criteria;



public interface MyClass101Repository 
{

	public List<MyClass101> findAll () ;
	public List<MyClass101> findByCriteria (MyClass101Criteria myClass101Criteria) ;
	public MyClass101 findById (Long id) ;
	public MyClass101 save (MyClass101 myclass101) ;

}
