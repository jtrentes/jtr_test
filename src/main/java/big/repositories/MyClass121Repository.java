package big.repositories;

import java.util.List;
import big.domain.MyClass121;
import big.repositories.criteria.MyClass121Criteria;



public interface MyClass121Repository 
{

	public List<MyClass121> findAll () ;
	public List<MyClass121> findByCriteria (MyClass121Criteria myClass121Criteria) ;
	public MyClass121 findById (Long id) ;
	public MyClass121 save (MyClass121 myclass121) ;

}
