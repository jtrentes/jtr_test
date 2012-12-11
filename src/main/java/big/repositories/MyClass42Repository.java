package big.repositories;

import big.domain.MyClass42;
import java.util.List;
import big.repositories.criteria.MyClass42Criteria;



public interface MyClass42Repository 
{

	public List<MyClass42> findAll () ;
	public List<MyClass42> findByCriteria (MyClass42Criteria myClass42Criteria) ;
	public MyClass42 findById (Long id) ;
	public MyClass42 save (MyClass42 myclass42) ;

}
