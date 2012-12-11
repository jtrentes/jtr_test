package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass119Criteria;
import big.domain.MyClass119;



public interface MyClass119Repository 
{

	public List<MyClass119> findAll () ;
	public List<MyClass119> findByCriteria (MyClass119Criteria myClass119Criteria) ;
	public MyClass119 findById (Long id) ;
	public MyClass119 save (MyClass119 myclass119) ;

}
