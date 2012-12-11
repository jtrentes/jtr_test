package big.repositories;

import big.repositories.criteria.MyClass58Criteria;
import java.util.List;
import big.domain.MyClass58;



public interface MyClass58Repository 
{

	public List<MyClass58> findAll () ;
	public List<MyClass58> findByCriteria (MyClass58Criteria myClass58Criteria) ;
	public MyClass58 findById (Long id) ;
	public MyClass58 save (MyClass58 myclass58) ;

}
