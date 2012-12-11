package big.repositories;

import big.domain.MyClass49;
import big.repositories.criteria.MyClass49Criteria;
import java.util.List;



public interface MyClass49Repository 
{

	public List<MyClass49> findAll () ;
	public List<MyClass49> findByCriteria (MyClass49Criteria myClass49Criteria) ;
	public MyClass49 findById (Long id) ;
	public MyClass49 save (MyClass49 myclass49) ;

}
