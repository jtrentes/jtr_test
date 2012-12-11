package big.repositories;

import big.repositories.criteria.MyClass120Criteria;
import java.util.List;
import big.domain.MyClass120;



public interface MyClass120Repository 
{

	public List<MyClass120> findAll () ;
	public List<MyClass120> findByCriteria (MyClass120Criteria myClass120Criteria) ;
	public MyClass120 findById (Long id) ;
	public MyClass120 save (MyClass120 myclass120) ;

}
