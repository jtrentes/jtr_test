package big.repositories;

import big.domain.MyClass134;
import java.util.List;
import big.repositories.criteria.MyClass134Criteria;



public interface MyClass134Repository 
{

	public List<MyClass134> findAll () ;
	public List<MyClass134> findByCriteria (MyClass134Criteria myClass134Criteria) ;
	public MyClass134 findById (Long id) ;
	public MyClass134 save (MyClass134 myclass134) ;

}
