package big.repositories;

import big.repositories.criteria.MyClass46Criteria;
import java.util.List;
import big.domain.MyClass46;



public interface MyClass46Repository 
{

	public List<MyClass46> findAll () ;
	public List<MyClass46> findByCriteria (MyClass46Criteria myClass46Criteria) ;
	public MyClass46 findById (Long id) ;
	public MyClass46 save (MyClass46 myclass46) ;

}
