package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass72Criteria;
import big.domain.MyClass72;



public interface MyClass72Repository 
{

	public List<MyClass72> findAll () ;
	public List<MyClass72> findByCriteria (MyClass72Criteria myClass72Criteria) ;
	public MyClass72 findById (Long id) ;
	public MyClass72 save (MyClass72 myclass72) ;

}
