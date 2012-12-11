package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass17Criteria;
import big.domain.MyClass17;



public interface MyClass17Repository 
{

	public List<MyClass17> findAll () ;
	public List<MyClass17> findByCriteria (MyClass17Criteria myClass17Criteria) ;
	public MyClass17 findById (Long id) ;
	public MyClass17 save (MyClass17 myclass17) ;

}
