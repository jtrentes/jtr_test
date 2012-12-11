package big.repositories;

import big.repositories.criteria.MyClass127Criteria;
import java.util.List;
import big.domain.MyClass127;



public interface MyClass127Repository 
{

	public List<MyClass127> findAll () ;
	public List<MyClass127> findByCriteria (MyClass127Criteria myClass127Criteria) ;
	public MyClass127 findById (Long id) ;
	public MyClass127 save (MyClass127 myclass127) ;

}
