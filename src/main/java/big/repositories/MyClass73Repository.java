package big.repositories;

import big.repositories.criteria.MyClass73Criteria;
import java.util.List;
import big.domain.MyClass73;



public interface MyClass73Repository 
{

	public List<MyClass73> findAll () ;
	public List<MyClass73> findByCriteria (MyClass73Criteria myClass73Criteria) ;
	public MyClass73 findById (Long id) ;
	public MyClass73 save (MyClass73 myclass73) ;

}
