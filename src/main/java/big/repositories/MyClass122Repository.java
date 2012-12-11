package big.repositories;

import big.repositories.criteria.MyClass122Criteria;
import big.domain.MyClass122;
import java.util.List;



public interface MyClass122Repository 
{

	public List<MyClass122> findAll () ;
	public List<MyClass122> findByCriteria (MyClass122Criteria myClass122Criteria) ;
	public MyClass122 findById (Long id) ;
	public MyClass122 save (MyClass122 myclass122) ;

}
