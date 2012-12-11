package big.repositories;

import big.repositories.criteria.MyClass106Criteria;
import big.domain.MyClass106;
import java.util.List;



public interface MyClass106Repository 
{

	public List<MyClass106> findAll () ;
	public List<MyClass106> findByCriteria (MyClass106Criteria myClass106Criteria) ;
	public MyClass106 findById (Long id) ;
	public MyClass106 save (MyClass106 myclass106) ;

}
