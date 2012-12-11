package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass43Criteria;
import big.domain.MyClass43;



public interface MyClass43Repository 
{

	public List<MyClass43> findAll () ;
	public List<MyClass43> findByCriteria (MyClass43Criteria myClass43Criteria) ;
	public MyClass43 findById (Long id) ;
	public MyClass43 save (MyClass43 myclass43) ;

}
