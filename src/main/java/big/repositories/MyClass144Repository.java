package big.repositories;

import java.util.List;
import big.domain.MyClass144;
import big.repositories.criteria.MyClass144Criteria;



public interface MyClass144Repository 
{

	public List<MyClass144> findAll () ;
	public List<MyClass144> findByCriteria (MyClass144Criteria myClass144Criteria) ;
	public MyClass144 findById (Long id) ;
	public MyClass144 save (MyClass144 myclass144) ;

}
