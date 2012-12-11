package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass153Criteria;
import big.domain.MyClass153;



public interface MyClass153Repository 
{

	public List<MyClass153> findAll () ;
	public List<MyClass153> findByCriteria (MyClass153Criteria myClass153Criteria) ;
	public MyClass153 findById (Long id) ;
	public MyClass153 save (MyClass153 myclass153) ;

}
