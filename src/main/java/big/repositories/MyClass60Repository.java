package big.repositories;

import big.repositories.criteria.MyClass60Criteria;
import java.util.List;
import big.domain.MyClass60;



public interface MyClass60Repository 
{

	public List<MyClass60> findAll () ;
	public List<MyClass60> findByCriteria (MyClass60Criteria myClass60Criteria) ;
	public MyClass60 findById (Long id) ;
	public MyClass60 save (MyClass60 myclass60) ;

}
