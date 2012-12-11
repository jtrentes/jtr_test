package big.repositories;

import big.repositories.criteria.MyClass125Criteria;
import java.util.List;
import big.domain.MyClass125;



public interface MyClass125Repository 
{

	public List<MyClass125> findAll () ;
	public List<MyClass125> findByCriteria (MyClass125Criteria myClass125Criteria) ;
	public MyClass125 findById (Long id) ;
	public MyClass125 save (MyClass125 myclass125) ;

}
