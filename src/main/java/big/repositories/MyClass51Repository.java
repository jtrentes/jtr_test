package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass51Criteria;
import big.domain.MyClass51;



public interface MyClass51Repository 
{

	public List<MyClass51> findAll () ;
	public List<MyClass51> findByCriteria (MyClass51Criteria myClass51Criteria) ;
	public MyClass51 findById (Long id) ;
	public MyClass51 save (MyClass51 myclass51) ;

}
