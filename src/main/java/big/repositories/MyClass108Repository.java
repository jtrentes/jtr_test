package big.repositories;

import big.domain.MyClass108;
import java.util.List;
import big.repositories.criteria.MyClass108Criteria;



public interface MyClass108Repository 
{

	public List<MyClass108> findAll () ;
	public List<MyClass108> findByCriteria (MyClass108Criteria myClass108Criteria) ;
	public MyClass108 findById (Long id) ;
	public MyClass108 save (MyClass108 myclass108) ;

}
