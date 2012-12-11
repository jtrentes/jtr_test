package big.repositories;

import big.repositories.criteria.MyClass148Criteria;
import java.util.List;
import big.domain.MyClass148;



public interface MyClass148Repository 
{

	public List<MyClass148> findAll () ;
	public List<MyClass148> findByCriteria (MyClass148Criteria myClass148Criteria) ;
	public MyClass148 findById (Long id) ;
	public MyClass148 save (MyClass148 myclass148) ;

}
