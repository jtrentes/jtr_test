package big.repositories;

import big.domain.MyClass128;
import java.util.List;
import big.repositories.criteria.MyClass128Criteria;



public interface MyClass128Repository 
{

	public List<MyClass128> findAll () ;
	public List<MyClass128> findByCriteria (MyClass128Criteria myClass128Criteria) ;
	public MyClass128 findById (Long id) ;
	public MyClass128 save (MyClass128 myclass128) ;

}
