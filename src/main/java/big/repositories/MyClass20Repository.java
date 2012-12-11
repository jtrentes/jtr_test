package big.repositories;

import big.domain.MyClass20;
import java.util.List;
import big.repositories.criteria.MyClass20Criteria;



public interface MyClass20Repository 
{

	public List<MyClass20> findAll () ;
	public List<MyClass20> findByCriteria (MyClass20Criteria myClass20Criteria) ;
	public MyClass20 findById (Long id) ;
	public MyClass20 save (MyClass20 myclass20) ;

}
