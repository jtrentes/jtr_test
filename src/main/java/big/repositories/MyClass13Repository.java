package big.repositories;

import big.repositories.criteria.MyClass13Criteria;
import big.domain.MyClass13;
import java.util.List;



public interface MyClass13Repository 
{

	public List<MyClass13> findAll () ;
	public List<MyClass13> findByCriteria (MyClass13Criteria myClass13Criteria) ;
	public MyClass13 findById (Long id) ;
	public MyClass13 save (MyClass13 myclass13) ;

}
