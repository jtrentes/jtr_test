package big.repositories;

import big.domain.MyClass24;
import big.repositories.criteria.MyClass24Criteria;
import java.util.List;



public interface MyClass24Repository 
{

	public List<MyClass24> findAll () ;
	public List<MyClass24> findByCriteria (MyClass24Criteria myClass24Criteria) ;
	public MyClass24 findById (Long id) ;
	public MyClass24 save (MyClass24 myclass24) ;

}
