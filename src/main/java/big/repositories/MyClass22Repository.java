package big.repositories;

import big.domain.MyClass22;
import java.util.List;
import big.repositories.criteria.MyClass22Criteria;



public interface MyClass22Repository 
{

	public List<MyClass22> findAll () ;
	public List<MyClass22> findByCriteria (MyClass22Criteria myClass22Criteria) ;
	public MyClass22 findById (Long id) ;
	public MyClass22 save (MyClass22 myclass22) ;

}
