package big.repositories;

import big.domain.MyClass47;
import java.util.List;
import big.repositories.criteria.MyClass47Criteria;



public interface MyClass47Repository 
{

	public List<MyClass47> findAll () ;
	public List<MyClass47> findByCriteria (MyClass47Criteria myClass47Criteria) ;
	public MyClass47 findById (Long id) ;
	public MyClass47 save (MyClass47 myclass47) ;

}
