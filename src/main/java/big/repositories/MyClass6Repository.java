package big.repositories;

import big.domain.MyClass6;
import java.util.List;
import big.repositories.criteria.MyClass6Criteria;



public interface MyClass6Repository 
{

	public List<MyClass6> findAll () ;
	public List<MyClass6> findByCriteria (MyClass6Criteria myClass6Criteria) ;
	public MyClass6 findById (Long id) ;
	public MyClass6 save (MyClass6 myclass6) ;

}
