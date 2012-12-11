package big.repositories;

import big.domain.MyClass75;
import java.util.List;
import big.repositories.criteria.MyClass75Criteria;



public interface MyClass75Repository 
{

	public List<MyClass75> findAll () ;
	public List<MyClass75> findByCriteria (MyClass75Criteria myClass75Criteria) ;
	public MyClass75 findById (Long id) ;
	public MyClass75 save (MyClass75 myclass75) ;

}
