package big.repositories;

import java.util.List;
import big.domain.MyClass162;
import big.repositories.criteria.MyClass162Criteria;



public interface MyClass162Repository 
{

	public List<MyClass162> findAll () ;
	public List<MyClass162> findByCriteria (MyClass162Criteria myClass162Criteria) ;
	public MyClass162 findById (Long id) ;
	public MyClass162 save (MyClass162 myclass162) ;

}
