package big.repositories;

import big.repositories.criteria.MyClass156Criteria;
import java.util.List;
import big.domain.MyClass156;



public interface MyClass156Repository 
{

	public List<MyClass156> findAll () ;
	public List<MyClass156> findByCriteria (MyClass156Criteria myClass156Criteria) ;
	public MyClass156 findById (Long id) ;
	public MyClass156 save (MyClass156 myclass156) ;

}
