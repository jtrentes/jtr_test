package big.repositories;

import big.domain.MyClass102;
import java.util.List;
import big.repositories.criteria.MyClass102Criteria;



public interface MyClass102Repository 
{

	public List<MyClass102> findAll () ;
	public List<MyClass102> findByCriteria (MyClass102Criteria myClass102Criteria) ;
	public MyClass102 findById (Long id) ;
	public MyClass102 save (MyClass102 myclass102) ;

}
