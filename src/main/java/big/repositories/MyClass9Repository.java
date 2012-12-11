package big.repositories;

import big.domain.MyClass9;
import big.repositories.criteria.MyClass9Criteria;
import java.util.List;



public interface MyClass9Repository 
{

	public List<MyClass9> findAll () ;
	public List<MyClass9> findByCriteria (MyClass9Criteria myClass9Criteria) ;
	public MyClass9 findById (Long id) ;
	public MyClass9 save (MyClass9 myclass9) ;

}
