package big.repositories;

import big.domain.MyClass109;
import java.util.List;
import big.repositories.criteria.MyClass109Criteria;



public interface MyClass109Repository 
{

	public List<MyClass109> findAll () ;
	public List<MyClass109> findByCriteria (MyClass109Criteria myClass109Criteria) ;
	public MyClass109 findById (Long id) ;
	public MyClass109 save (MyClass109 myclass109) ;

}
