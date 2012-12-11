package big.repositories;

import big.domain.MyClass35;
import big.repositories.criteria.MyClass35Criteria;
import java.util.List;



public interface MyClass35Repository 
{

	public List<MyClass35> findAll () ;
	public List<MyClass35> findByCriteria (MyClass35Criteria myClass35Criteria) ;
	public MyClass35 findById (Long id) ;
	public MyClass35 save (MyClass35 myclass35) ;

}
