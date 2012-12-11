package big.repositories;

import big.domain.MyClass18;
import java.util.List;
import big.repositories.criteria.MyClass18Criteria;



public interface MyClass18Repository 
{

	public List<MyClass18> findAll () ;
	public List<MyClass18> findByCriteria (MyClass18Criteria myClass18Criteria) ;
	public MyClass18 findById (Long id) ;
	public MyClass18 save (MyClass18 myclass18) ;

}
