package big.repositories;

import big.domain.MyClass103;
import big.repositories.criteria.MyClass103Criteria;
import java.util.List;



public interface MyClass103Repository 
{

	public List<MyClass103> findAll () ;
	public List<MyClass103> findByCriteria (MyClass103Criteria myClass103Criteria) ;
	public MyClass103 findById (Long id) ;
	public MyClass103 save (MyClass103 myclass103) ;

}
