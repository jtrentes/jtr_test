package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass30Criteria;
import big.domain.MyClass30;



public interface MyClass30Repository 
{

	public List<MyClass30> findAll () ;
	public List<MyClass30> findByCriteria (MyClass30Criteria myClass30Criteria) ;
	public MyClass30 findById (Long id) ;
	public MyClass30 save (MyClass30 myclass30) ;

}
