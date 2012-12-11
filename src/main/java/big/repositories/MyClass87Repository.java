package big.repositories;

import big.repositories.criteria.MyClass87Criteria;
import big.domain.MyClass87;
import java.util.List;



public interface MyClass87Repository 
{

	public List<MyClass87> findAll () ;
	public List<MyClass87> findByCriteria (MyClass87Criteria myClass87Criteria) ;
	public MyClass87 findById (Long id) ;
	public MyClass87 save (MyClass87 myclass87) ;

}
