package big.repositories;

import java.util.List;
import big.domain.MyClass77;
import big.repositories.criteria.MyClass77Criteria;



public interface MyClass77Repository 
{

	public List<MyClass77> findAll () ;
	public List<MyClass77> findByCriteria (MyClass77Criteria myClass77Criteria) ;
	public MyClass77 findById (Long id) ;
	public MyClass77 save (MyClass77 myclass77) ;

}
