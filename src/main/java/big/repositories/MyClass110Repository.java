package big.repositories;

import big.domain.MyClass110;
import big.repositories.criteria.MyClass110Criteria;
import java.util.List;



public interface MyClass110Repository 
{

	public List<MyClass110> findAll () ;
	public List<MyClass110> findByCriteria (MyClass110Criteria myClass110Criteria) ;
	public MyClass110 findById (Long id) ;
	public MyClass110 save (MyClass110 myclass110) ;

}
