package big.repositories;

import big.repositories.criteria.MyClass2Criteria;
import big.domain.MyClass2;
import java.util.List;



public interface MyClass2Repository 
{

	public List<MyClass2> findAll () ;
	public List<MyClass2> findByCriteria (MyClass2Criteria myClass2Criteria) ;
	public MyClass2 findById (Long id) ;
	public MyClass2 save (MyClass2 myclass2) ;

}
