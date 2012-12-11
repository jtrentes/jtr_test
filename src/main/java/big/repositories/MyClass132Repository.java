package big.repositories;

import big.repositories.criteria.MyClass132Criteria;
import java.util.List;
import big.domain.MyClass132;



public interface MyClass132Repository 
{

	public List<MyClass132> findAll () ;
	public List<MyClass132> findByCriteria (MyClass132Criteria myClass132Criteria) ;
	public MyClass132 findById (Long id) ;
	public MyClass132 save (MyClass132 myclass132) ;

}
