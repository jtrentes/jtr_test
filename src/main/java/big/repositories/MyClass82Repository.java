package big.repositories;

import big.domain.MyClass82;
import big.repositories.criteria.MyClass82Criteria;
import java.util.List;



public interface MyClass82Repository 
{

	public List<MyClass82> findAll () ;
	public List<MyClass82> findByCriteria (MyClass82Criteria myClass82Criteria) ;
	public MyClass82 findById (Long id) ;
	public MyClass82 save (MyClass82 myclass82) ;

}
