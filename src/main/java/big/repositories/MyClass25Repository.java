package big.repositories;

import big.repositories.criteria.MyClass25Criteria;
import big.domain.MyClass25;
import java.util.List;



public interface MyClass25Repository 
{

	public List<MyClass25> findAll () ;
	public List<MyClass25> findByCriteria (MyClass25Criteria myClass25Criteria) ;
	public MyClass25 findById (Long id) ;
	public MyClass25 save (MyClass25 myclass25) ;

}
