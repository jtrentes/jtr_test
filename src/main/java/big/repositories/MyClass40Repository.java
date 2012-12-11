package big.repositories;

import big.domain.MyClass40;
import big.repositories.criteria.MyClass40Criteria;
import java.util.List;



public interface MyClass40Repository 
{

	public List<MyClass40> findAll () ;
	public List<MyClass40> findByCriteria (MyClass40Criteria myClass40Criteria) ;
	public MyClass40 findById (Long id) ;
	public MyClass40 save (MyClass40 myclass40) ;

}
