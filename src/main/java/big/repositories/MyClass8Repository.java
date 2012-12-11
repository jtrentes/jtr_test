package big.repositories;

import big.repositories.criteria.MyClass8Criteria;
import big.domain.MyClass8;
import java.util.List;



public interface MyClass8Repository 
{

	public List<MyClass8> findAll () ;
	public List<MyClass8> findByCriteria (MyClass8Criteria myClass8Criteria) ;
	public MyClass8 findById (Long id) ;
	public MyClass8 save (MyClass8 myclass8) ;

}
