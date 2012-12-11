package big.repositories;

import big.repositories.criteria.MyClass69Criteria;
import java.util.List;
import big.domain.MyClass69;



public interface MyClass69Repository 
{

	public List<MyClass69> findAll () ;
	public List<MyClass69> findByCriteria (MyClass69Criteria myClass69Criteria) ;
	public MyClass69 findById (Long id) ;
	public MyClass69 save (MyClass69 myclass69) ;

}
