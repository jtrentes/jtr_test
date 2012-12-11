package big.repositories;

import big.domain.MyClass64;
import big.repositories.criteria.MyClass64Criteria;
import java.util.List;



public interface MyClass64Repository 
{

	public List<MyClass64> findAll () ;
	public List<MyClass64> findByCriteria (MyClass64Criteria myClass64Criteria) ;
	public MyClass64 findById (Long id) ;
	public MyClass64 save (MyClass64 myclass64) ;

}
