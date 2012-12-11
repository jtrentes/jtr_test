package big.repositories;

import big.domain.MyClass78;
import big.repositories.criteria.MyClass78Criteria;
import java.util.List;



public interface MyClass78Repository 
{

	public List<MyClass78> findAll () ;
	public List<MyClass78> findByCriteria (MyClass78Criteria myClass78Criteria) ;
	public MyClass78 findById (Long id) ;
	public MyClass78 save (MyClass78 myclass78) ;

}
