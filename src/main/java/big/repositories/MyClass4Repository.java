package big.repositories;

import big.domain.MyClass4;
import java.util.List;
import big.repositories.criteria.MyClass4Criteria;



public interface MyClass4Repository 
{

	public List<MyClass4> findAll () ;
	public List<MyClass4> findByCriteria (MyClass4Criteria myClass4Criteria) ;
	public MyClass4 findById (Long id) ;
	public MyClass4 save (MyClass4 myclass4) ;

}
