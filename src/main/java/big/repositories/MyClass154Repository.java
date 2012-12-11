package big.repositories;

import big.domain.MyClass154;
import big.repositories.criteria.MyClass154Criteria;
import java.util.List;



public interface MyClass154Repository 
{

	public List<MyClass154> findAll () ;
	public List<MyClass154> findByCriteria (MyClass154Criteria myClass154Criteria) ;
	public MyClass154 findById (Long id) ;
	public MyClass154 save (MyClass154 myclass154) ;

}
