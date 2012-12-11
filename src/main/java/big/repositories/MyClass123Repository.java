package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass123Criteria;
import big.domain.MyClass123;



public interface MyClass123Repository 
{

	public List<MyClass123> findAll () ;
	public List<MyClass123> findByCriteria (MyClass123Criteria myClass123Criteria) ;
	public MyClass123 findById (Long id) ;
	public MyClass123 save (MyClass123 myclass123) ;

}
