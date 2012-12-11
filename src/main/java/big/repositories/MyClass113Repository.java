package big.repositories;

import big.repositories.criteria.MyClass113Criteria;
import big.domain.MyClass113;
import java.util.List;



public interface MyClass113Repository 
{

	public List<MyClass113> findAll () ;
	public List<MyClass113> findByCriteria (MyClass113Criteria myClass113Criteria) ;
	public MyClass113 findById (Long id) ;
	public MyClass113 save (MyClass113 myclass113) ;

}
