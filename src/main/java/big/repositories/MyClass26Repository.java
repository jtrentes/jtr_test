package big.repositories;

import big.domain.MyClass26;
import java.util.List;
import big.repositories.criteria.MyClass26Criteria;



public interface MyClass26Repository 
{

	public List<MyClass26> findAll () ;
	public List<MyClass26> findByCriteria (MyClass26Criteria myClass26Criteria) ;
	public MyClass26 findById (Long id) ;
	public MyClass26 save (MyClass26 myclass26) ;

}
