package big.repositories;

import big.repositories.criteria.MyClass129Criteria;
import big.domain.MyClass129;
import java.util.List;



public interface MyClass129Repository 
{

	public List<MyClass129> findAll () ;
	public List<MyClass129> findByCriteria (MyClass129Criteria myClass129Criteria) ;
	public MyClass129 findById (Long id) ;
	public MyClass129 save (MyClass129 myclass129) ;

}
