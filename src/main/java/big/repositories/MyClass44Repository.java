package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass44Criteria;
import big.domain.MyClass44;



public interface MyClass44Repository 
{

	public List<MyClass44> findAll () ;
	public List<MyClass44> findByCriteria (MyClass44Criteria myClass44Criteria) ;
	public MyClass44 findById (Long id) ;
	public MyClass44 save (MyClass44 myclass44) ;

}
