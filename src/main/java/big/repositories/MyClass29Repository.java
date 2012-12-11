package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass29Criteria;
import big.domain.MyClass29;



public interface MyClass29Repository 
{

	public List<MyClass29> findAll () ;
	public List<MyClass29> findByCriteria (MyClass29Criteria myClass29Criteria) ;
	public MyClass29 findById (Long id) ;
	public MyClass29 save (MyClass29 myclass29) ;

}
