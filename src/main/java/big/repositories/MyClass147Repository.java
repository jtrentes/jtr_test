package big.repositories;

import big.domain.MyClass147;
import big.repositories.criteria.MyClass147Criteria;
import java.util.List;



public interface MyClass147Repository 
{

	public List<MyClass147> findAll () ;
	public List<MyClass147> findByCriteria (MyClass147Criteria myClass147Criteria) ;
	public MyClass147 findById (Long id) ;
	public MyClass147 save (MyClass147 myclass147) ;

}
