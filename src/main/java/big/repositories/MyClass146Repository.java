package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass146Criteria;
import big.domain.MyClass146;



public interface MyClass146Repository 
{

	public List<MyClass146> findAll () ;
	public List<MyClass146> findByCriteria (MyClass146Criteria myClass146Criteria) ;
	public MyClass146 findById (Long id) ;
	public MyClass146 save (MyClass146 myclass146) ;

}
