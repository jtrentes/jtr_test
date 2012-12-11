package big.repositories;

import big.domain.MyClass28;
import big.repositories.criteria.MyClass28Criteria;
import java.util.List;



public interface MyClass28Repository 
{

	public List<MyClass28> findAll () ;
	public List<MyClass28> findByCriteria (MyClass28Criteria myClass28Criteria) ;
	public MyClass28 findById (Long id) ;
	public MyClass28 save (MyClass28 myclass28) ;

}
