package big.repositories;

import big.domain.MyClass84;
import java.util.List;
import big.repositories.criteria.MyClass84Criteria;



public interface MyClass84Repository 
{

	public List<MyClass84> findAll () ;
	public List<MyClass84> findByCriteria (MyClass84Criteria myClass84Criteria) ;
	public MyClass84 findById (Long id) ;
	public MyClass84 save (MyClass84 myclass84) ;

}
