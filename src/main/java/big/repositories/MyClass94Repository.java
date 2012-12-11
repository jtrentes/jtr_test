package big.repositories;

import big.repositories.criteria.MyClass94Criteria;
import java.util.List;
import big.domain.MyClass94;



public interface MyClass94Repository 
{

	public List<MyClass94> findAll () ;
	public List<MyClass94> findByCriteria (MyClass94Criteria myClass94Criteria) ;
	public MyClass94 findById (Long id) ;
	public MyClass94 save (MyClass94 myclass94) ;

}
