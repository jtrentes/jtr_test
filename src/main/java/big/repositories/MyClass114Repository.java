package big.repositories;

import big.repositories.criteria.MyClass114Criteria;
import java.util.List;
import big.domain.MyClass114;



public interface MyClass114Repository 
{

	public List<MyClass114> findAll () ;
	public List<MyClass114> findByCriteria (MyClass114Criteria myClass114Criteria) ;
	public MyClass114 findById (Long id) ;
	public MyClass114 save (MyClass114 myclass114) ;

}
