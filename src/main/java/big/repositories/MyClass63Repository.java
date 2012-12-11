package big.repositories;

import big.domain.MyClass63;
import big.repositories.criteria.MyClass63Criteria;
import java.util.List;



public interface MyClass63Repository 
{

	public List<MyClass63> findAll () ;
	public List<MyClass63> findByCriteria (MyClass63Criteria myClass63Criteria) ;
	public MyClass63 findById (Long id) ;
	public MyClass63 save (MyClass63 myclass63) ;

}
