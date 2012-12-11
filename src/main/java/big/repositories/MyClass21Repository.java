package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass21Criteria;
import big.domain.MyClass21;



public interface MyClass21Repository 
{

	public List<MyClass21> findAll () ;
	public List<MyClass21> findByCriteria (MyClass21Criteria myClass21Criteria) ;
	public MyClass21 findById (Long id) ;
	public MyClass21 save (MyClass21 myclass21) ;

}
