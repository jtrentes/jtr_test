package big.repositories;

import big.repositories.criteria.MyClass124Criteria;
import big.domain.MyClass124;
import java.util.List;



public interface MyClass124Repository 
{

	public List<MyClass124> findAll () ;
	public List<MyClass124> findByCriteria (MyClass124Criteria myClass124Criteria) ;
	public MyClass124 findById (Long id) ;
	public MyClass124 save (MyClass124 myclass124) ;

}
