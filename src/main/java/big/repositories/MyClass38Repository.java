package big.repositories;

import big.repositories.criteria.MyClass38Criteria;
import java.util.List;
import big.domain.MyClass38;



public interface MyClass38Repository 
{

	public List<MyClass38> findAll () ;
	public List<MyClass38> findByCriteria (MyClass38Criteria myClass38Criteria) ;
	public MyClass38 findById (Long id) ;
	public MyClass38 save (MyClass38 myclass38) ;

}
