package big.repositories;

import java.util.List;
import big.domain.MyClass88;
import big.repositories.criteria.MyClass88Criteria;



public interface MyClass88Repository 
{

	public List<MyClass88> findAll () ;
	public List<MyClass88> findByCriteria (MyClass88Criteria myClass88Criteria) ;
	public MyClass88 findById (Long id) ;
	public MyClass88 save (MyClass88 myclass88) ;

}
