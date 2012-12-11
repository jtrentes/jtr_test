package big.repositories;

import java.util.List;
import big.domain.MyClass161;
import big.repositories.criteria.MyClass161Criteria;



public interface MyClass161Repository 
{

	public List<MyClass161> findAll () ;
	public List<MyClass161> findByCriteria (MyClass161Criteria myClass161Criteria) ;
	public MyClass161 findById (Long id) ;
	public MyClass161 save (MyClass161 myclass161) ;

}
