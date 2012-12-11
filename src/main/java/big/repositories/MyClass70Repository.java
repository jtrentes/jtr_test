package big.repositories;

import java.util.List;
import big.domain.MyClass70;
import big.repositories.criteria.MyClass70Criteria;



public interface MyClass70Repository 
{

	public List<MyClass70> findAll () ;
	public List<MyClass70> findByCriteria (MyClass70Criteria myClass70Criteria) ;
	public MyClass70 findById (Long id) ;
	public MyClass70 save (MyClass70 myclass70) ;

}
