package big.repositories;

import big.domain.MyClass12;
import java.util.List;
import big.repositories.criteria.MyClass12Criteria;



public interface MyClass12Repository 
{

	public List<MyClass12> findAll () ;
	public List<MyClass12> findByCriteria (MyClass12Criteria myClass12Criteria) ;
	public MyClass12 findById (Long id) ;
	public MyClass12 save (MyClass12 myclass12) ;

}
