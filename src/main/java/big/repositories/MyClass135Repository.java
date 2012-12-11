package big.repositories;

import big.domain.MyClass135;
import big.repositories.criteria.MyClass135Criteria;
import java.util.List;



public interface MyClass135Repository 
{

	public List<MyClass135> findAll () ;
	public List<MyClass135> findByCriteria (MyClass135Criteria myClass135Criteria) ;
	public MyClass135 findById (Long id) ;
	public MyClass135 save (MyClass135 myclass135) ;

}
