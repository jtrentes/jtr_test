package big.repositories;

import big.domain.MyClass7;
import java.util.List;
import big.repositories.criteria.MyClass7Criteria;



public interface MyClass7Repository 
{

	public List<MyClass7> findAll () ;
	public List<MyClass7> findByCriteria (MyClass7Criteria myClass7Criteria) ;
	public MyClass7 findById (Long id) ;
	public MyClass7 save (MyClass7 myclass7) ;

}
