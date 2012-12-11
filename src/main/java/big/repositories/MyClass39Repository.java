package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass39Criteria;
import big.domain.MyClass39;



public interface MyClass39Repository 
{

	public List<MyClass39> findAll () ;
	public List<MyClass39> findByCriteria (MyClass39Criteria myClass39Criteria) ;
	public MyClass39 findById (Long id) ;
	public MyClass39 save (MyClass39 myclass39) ;

}
