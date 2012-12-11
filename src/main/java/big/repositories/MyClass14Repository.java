package big.repositories;

import big.domain.MyClass14;
import java.util.List;
import big.repositories.criteria.MyClass14Criteria;



public interface MyClass14Repository 
{

	public List<MyClass14> findAll () ;
	public List<MyClass14> findByCriteria (MyClass14Criteria myClass14Criteria) ;
	public MyClass14 findById (Long id) ;
	public MyClass14 save (MyClass14 myclass14) ;

}
