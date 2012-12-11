package big.repositories;

import big.repositories.criteria.MyClass95Criteria;
import big.domain.MyClass95;
import java.util.List;



public interface MyClass95Repository 
{

	public List<MyClass95> findAll () ;
	public List<MyClass95> findByCriteria (MyClass95Criteria myClass95Criteria) ;
	public MyClass95 findById (Long id) ;
	public MyClass95 save (MyClass95 myclass95) ;

}
