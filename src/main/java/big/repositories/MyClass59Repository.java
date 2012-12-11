package big.repositories;

import big.domain.MyClass59;
import big.repositories.criteria.MyClass59Criteria;
import java.util.List;



public interface MyClass59Repository 
{

	public List<MyClass59> findAll () ;
	public List<MyClass59> findByCriteria (MyClass59Criteria myClass59Criteria) ;
	public MyClass59 findById (Long id) ;
	public MyClass59 save (MyClass59 myclass59) ;

}
