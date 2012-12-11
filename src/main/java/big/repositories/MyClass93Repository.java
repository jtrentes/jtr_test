package big.repositories;

import big.domain.MyClass93;
import java.util.List;
import big.repositories.criteria.MyClass93Criteria;



public interface MyClass93Repository 
{

	public List<MyClass93> findAll () ;
	public List<MyClass93> findByCriteria (MyClass93Criteria myClass93Criteria) ;
	public MyClass93 findById (Long id) ;
	public MyClass93 save (MyClass93 myclass93) ;

}
