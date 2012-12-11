package big.repositories;

import big.repositories.criteria.MyClass37Criteria;
import java.util.List;
import big.domain.MyClass37;



public interface MyClass37Repository 
{

	public List<MyClass37> findAll () ;
	public List<MyClass37> findByCriteria (MyClass37Criteria myClass37Criteria) ;
	public MyClass37 findById (Long id) ;
	public MyClass37 save (MyClass37 myclass37) ;

}
