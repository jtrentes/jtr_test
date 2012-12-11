package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass105Criteria;
import big.domain.MyClass105;



public interface MyClass105Repository 
{

	public List<MyClass105> findAll () ;
	public List<MyClass105> findByCriteria (MyClass105Criteria myClass105Criteria) ;
	public MyClass105 findById (Long id) ;
	public MyClass105 save (MyClass105 myclass105) ;

}
