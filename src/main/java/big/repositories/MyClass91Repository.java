package big.repositories;

import java.util.List;
import big.domain.MyClass91;
import big.repositories.criteria.MyClass91Criteria;



public interface MyClass91Repository 
{

	public List<MyClass91> findAll () ;
	public List<MyClass91> findByCriteria (MyClass91Criteria myClass91Criteria) ;
	public MyClass91 findById (Long id) ;
	public MyClass91 save (MyClass91 myclass91) ;

}
