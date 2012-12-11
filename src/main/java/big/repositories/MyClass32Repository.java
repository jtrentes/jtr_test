package big.repositories;

import big.domain.MyClass32;
import java.util.List;
import big.repositories.criteria.MyClass32Criteria;



public interface MyClass32Repository 
{

	public List<MyClass32> findAll () ;
	public List<MyClass32> findByCriteria (MyClass32Criteria myClass32Criteria) ;
	public MyClass32 findById (Long id) ;
	public MyClass32 save (MyClass32 myclass32) ;

}
