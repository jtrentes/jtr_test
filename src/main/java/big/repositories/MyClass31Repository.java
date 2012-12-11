package big.repositories;

import big.repositories.criteria.MyClass31Criteria;
import java.util.List;
import big.domain.MyClass31;



public interface MyClass31Repository 
{

	public List<MyClass31> findAll () ;
	public List<MyClass31> findByCriteria (MyClass31Criteria myClass31Criteria) ;
	public MyClass31 findById (Long id) ;
	public MyClass31 save (MyClass31 myclass31) ;

}
