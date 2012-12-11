package big.repositories;

import big.repositories.criteria.MyClass145Criteria;
import java.util.List;
import big.domain.MyClass145;



public interface MyClass145Repository 
{

	public List<MyClass145> findAll () ;
	public List<MyClass145> findByCriteria (MyClass145Criteria myClass145Criteria) ;
	public MyClass145 findById (Long id) ;
	public MyClass145 save (MyClass145 myclass145) ;

}
