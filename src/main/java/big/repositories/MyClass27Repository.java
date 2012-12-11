package big.repositories;

import big.repositories.criteria.MyClass27Criteria;
import big.domain.MyClass27;
import java.util.List;



public interface MyClass27Repository 
{

	public List<MyClass27> findAll () ;
	public List<MyClass27> findByCriteria (MyClass27Criteria myClass27Criteria) ;
	public MyClass27 findById (Long id) ;
	public MyClass27 save (MyClass27 myclass27) ;

}
