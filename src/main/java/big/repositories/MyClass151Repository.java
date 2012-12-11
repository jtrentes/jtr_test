package big.repositories;

import big.repositories.criteria.MyClass151Criteria;
import java.util.List;
import big.domain.MyClass151;



public interface MyClass151Repository 
{

	public List<MyClass151> findAll () ;
	public List<MyClass151> findByCriteria (MyClass151Criteria myClass151Criteria) ;
	public MyClass151 findById (Long id) ;
	public MyClass151 save (MyClass151 myclass151) ;

}
