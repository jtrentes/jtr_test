package big.repositories;

import java.util.List;
import big.domain.MyClass136;
import big.repositories.criteria.MyClass136Criteria;



public interface MyClass136Repository 
{

	public List<MyClass136> findAll () ;
	public List<MyClass136> findByCriteria (MyClass136Criteria myClass136Criteria) ;
	public MyClass136 findById (Long id) ;
	public MyClass136 save (MyClass136 myclass136) ;

}
