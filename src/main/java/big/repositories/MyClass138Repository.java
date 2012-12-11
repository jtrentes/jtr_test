package big.repositories;

import big.domain.MyClass138;
import big.repositories.criteria.MyClass138Criteria;
import java.util.List;



public interface MyClass138Repository 
{

	public List<MyClass138> findAll () ;
	public List<MyClass138> findByCriteria (MyClass138Criteria myClass138Criteria) ;
	public MyClass138 findById (Long id) ;
	public MyClass138 save (MyClass138 myclass138) ;

}
