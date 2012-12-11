package big.repositories;

import big.domain.MyClass74;
import big.repositories.criteria.MyClass74Criteria;
import java.util.List;



public interface MyClass74Repository 
{

	public List<MyClass74> findAll () ;
	public List<MyClass74> findByCriteria (MyClass74Criteria myClass74Criteria) ;
	public MyClass74 findById (Long id) ;
	public MyClass74 save (MyClass74 myclass74) ;

}
