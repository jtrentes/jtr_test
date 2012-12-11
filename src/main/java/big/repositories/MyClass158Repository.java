package big.repositories;

import big.domain.MyClass158;
import java.util.List;
import big.repositories.criteria.MyClass158Criteria;



public interface MyClass158Repository 
{

	public List<MyClass158> findAll () ;
	public List<MyClass158> findByCriteria (MyClass158Criteria myClass158Criteria) ;
	public MyClass158 findById (Long id) ;
	public MyClass158 save (MyClass158 myclass158) ;

}
