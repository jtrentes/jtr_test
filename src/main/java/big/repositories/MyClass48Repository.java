package big.repositories;

import big.repositories.criteria.MyClass48Criteria;
import big.domain.MyClass48;
import java.util.List;



public interface MyClass48Repository 
{

	public List<MyClass48> findAll () ;
	public List<MyClass48> findByCriteria (MyClass48Criteria myClass48Criteria) ;
	public MyClass48 findById (Long id) ;
	public MyClass48 save (MyClass48 myclass48) ;

}
