package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass117Criteria;
import big.domain.MyClass117;



public interface MyClass117Repository 
{

	public List<MyClass117> findAll () ;
	public List<MyClass117> findByCriteria (MyClass117Criteria myClass117Criteria) ;
	public MyClass117 findById (Long id) ;
	public MyClass117 save (MyClass117 myclass117) ;

}
