package big.repositories;

import big.repositories.criteria.MyClass137Criteria;
import big.domain.MyClass137;
import java.util.List;



public interface MyClass137Repository 
{

	public List<MyClass137> findAll () ;
	public List<MyClass137> findByCriteria (MyClass137Criteria myClass137Criteria) ;
	public MyClass137 findById (Long id) ;
	public MyClass137 save (MyClass137 myclass137) ;

}
