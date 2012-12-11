package big.repositories;

import big.domain.MyClass23;
import java.util.List;
import big.repositories.criteria.MyClass23Criteria;



public interface MyClass23Repository 
{

	public List<MyClass23> findAll () ;
	public List<MyClass23> findByCriteria (MyClass23Criteria myClass23Criteria) ;
	public MyClass23 findById (Long id) ;
	public MyClass23 save (MyClass23 myclass23) ;

}
