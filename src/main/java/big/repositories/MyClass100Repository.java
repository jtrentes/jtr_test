package big.repositories;

import big.repositories.criteria.MyClass100Criteria;
import java.util.List;
import big.domain.MyClass100;



public interface MyClass100Repository 
{

	public List<MyClass100> findAll () ;
	public List<MyClass100> findByCriteria (MyClass100Criteria myClass100Criteria) ;
	public MyClass100 findById (Long id) ;
	public MyClass100 save (MyClass100 myclass100) ;

}
