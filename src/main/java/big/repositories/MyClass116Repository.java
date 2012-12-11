package big.repositories;

import big.repositories.criteria.MyClass116Criteria;
import java.util.List;
import big.domain.MyClass116;



public interface MyClass116Repository 
{

	public List<MyClass116> findAll () ;
	public List<MyClass116> findByCriteria (MyClass116Criteria myClass116Criteria) ;
	public MyClass116 findById (Long id) ;
	public MyClass116 save (MyClass116 myclass116) ;

}
