package big.repositories;

import big.domain.MyClass16;
import java.util.List;
import big.repositories.criteria.MyClass16Criteria;



public interface MyClass16Repository 
{

	public List<MyClass16> findAll () ;
	public List<MyClass16> findByCriteria (MyClass16Criteria myClass16Criteria) ;
	public MyClass16 findById (Long id) ;
	public MyClass16 save (MyClass16 myclass16) ;

}
