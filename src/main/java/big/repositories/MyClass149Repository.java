package big.repositories;

import big.repositories.criteria.MyClass149Criteria;
import big.domain.MyClass149;
import java.util.List;



public interface MyClass149Repository 
{

	public List<MyClass149> findAll () ;
	public List<MyClass149> findByCriteria (MyClass149Criteria myClass149Criteria) ;
	public MyClass149 findById (Long id) ;
	public MyClass149 save (MyClass149 myclass149) ;

}
