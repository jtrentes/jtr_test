package big.repositories;

import big.domain.MyClass99;
import java.util.List;
import big.repositories.criteria.MyClass99Criteria;



public interface MyClass99Repository 
{

	public List<MyClass99> findAll () ;
	public List<MyClass99> findByCriteria (MyClass99Criteria myClass99Criteria) ;
	public MyClass99 findById (Long id) ;
	public MyClass99 save (MyClass99 myclass99) ;

}
