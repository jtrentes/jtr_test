package big.repositories;

import big.domain.MyClass54;
import java.util.List;
import big.repositories.criteria.MyClass54Criteria;



public interface MyClass54Repository 
{

	public List<MyClass54> findAll () ;
	public List<MyClass54> findByCriteria (MyClass54Criteria myClass54Criteria) ;
	public MyClass54 findById (Long id) ;
	public MyClass54 save (MyClass54 myclass54) ;

}
