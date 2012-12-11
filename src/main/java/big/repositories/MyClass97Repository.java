package big.repositories;

import big.domain.MyClass97;
import java.util.List;
import big.repositories.criteria.MyClass97Criteria;



public interface MyClass97Repository 
{

	public List<MyClass97> findAll () ;
	public List<MyClass97> findByCriteria (MyClass97Criteria myClass97Criteria) ;
	public MyClass97 findById (Long id) ;
	public MyClass97 save (MyClass97 myclass97) ;

}
