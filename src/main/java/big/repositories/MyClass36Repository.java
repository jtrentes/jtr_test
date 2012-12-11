package big.repositories;

import java.util.List;
import big.domain.MyClass36;
import big.repositories.criteria.MyClass36Criteria;



public interface MyClass36Repository 
{

	public List<MyClass36> findAll () ;
	public List<MyClass36> findByCriteria (MyClass36Criteria myClass36Criteria) ;
	public MyClass36 findById (Long id) ;
	public MyClass36 save (MyClass36 myclass36) ;

}
