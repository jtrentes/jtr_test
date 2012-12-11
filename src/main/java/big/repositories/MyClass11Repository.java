package big.repositories;

import big.repositories.criteria.MyClass11Criteria;
import java.util.List;
import big.domain.MyClass11;



public interface MyClass11Repository 
{

	public List<MyClass11> findAll () ;
	public List<MyClass11> findByCriteria (MyClass11Criteria myClass11Criteria) ;
	public MyClass11 findById (Long id) ;
	public MyClass11 save (MyClass11 myclass11) ;

}
