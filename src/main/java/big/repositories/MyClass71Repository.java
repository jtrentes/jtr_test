package big.repositories;

import big.repositories.criteria.MyClass71Criteria;
import big.domain.MyClass71;
import java.util.List;



public interface MyClass71Repository 
{

	public List<MyClass71> findAll () ;
	public List<MyClass71> findByCriteria (MyClass71Criteria myClass71Criteria) ;
	public MyClass71 findById (Long id) ;
	public MyClass71 save (MyClass71 myclass71) ;

}
