package big.repositories;

import java.util.List;
import big.domain.MyClass33;
import big.repositories.criteria.MyClass33Criteria;



public interface MyClass33Repository 
{

	public List<MyClass33> findAll () ;
	public List<MyClass33> findByCriteria (MyClass33Criteria myClass33Criteria) ;
	public MyClass33 findById (Long id) ;
	public MyClass33 save (MyClass33 myclass33) ;

}
