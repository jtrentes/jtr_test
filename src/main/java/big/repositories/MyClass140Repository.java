package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass140Criteria;
import big.domain.MyClass140;



public interface MyClass140Repository 
{

	public List<MyClass140> findAll () ;
	public List<MyClass140> findByCriteria (MyClass140Criteria myClass140Criteria) ;
	public MyClass140 findById (Long id) ;
	public MyClass140 save (MyClass140 myclass140) ;

}
