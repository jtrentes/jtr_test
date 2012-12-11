package big.repositories;

import big.domain.MyClass79;
import big.repositories.criteria.MyClass79Criteria;
import java.util.List;



public interface MyClass79Repository 
{

	public List<MyClass79> findAll () ;
	public List<MyClass79> findByCriteria (MyClass79Criteria myClass79Criteria) ;
	public MyClass79 findById (Long id) ;
	public MyClass79 save (MyClass79 myclass79) ;

}
