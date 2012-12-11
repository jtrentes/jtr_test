package big.repositories;

import big.repositories.criteria.MyClass96Criteria;
import big.domain.MyClass96;
import java.util.List;



public interface MyClass96Repository 
{

	public List<MyClass96> findAll () ;
	public List<MyClass96> findByCriteria (MyClass96Criteria myClass96Criteria) ;
	public MyClass96 findById (Long id) ;
	public MyClass96 save (MyClass96 myclass96) ;

}
