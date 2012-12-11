package big.repositories;

import big.domain.MyClass3;
import java.util.List;
import big.repositories.criteria.MyClass3Criteria;



public interface MyClass3Repository 
{

	public List<MyClass3> findAll () ;
	public List<MyClass3> findByCriteria (MyClass3Criteria myClass3Criteria) ;
	public MyClass3 findById (Long id) ;
	public MyClass3 save (MyClass3 myclass3) ;

}
