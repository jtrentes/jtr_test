package big.repositories;

import big.domain.MyClass53;
import java.util.List;
import big.repositories.criteria.MyClass53Criteria;



public interface MyClass53Repository 
{

	public List<MyClass53> findAll () ;
	public List<MyClass53> findByCriteria (MyClass53Criteria myClass53Criteria) ;
	public MyClass53 findById (Long id) ;
	public MyClass53 save (MyClass53 myclass53) ;

}
