package big.repositories;

import big.domain.MyClass143;
import big.repositories.criteria.MyClass143Criteria;
import java.util.List;



public interface MyClass143Repository 
{

	public List<MyClass143> findAll () ;
	public List<MyClass143> findByCriteria (MyClass143Criteria myClass143Criteria) ;
	public MyClass143 findById (Long id) ;
	public MyClass143 save (MyClass143 myclass143) ;

}
