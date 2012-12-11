package big.repositories;

import big.domain.MyClass163;
import java.util.List;
import big.repositories.criteria.MyClass163Criteria;



public interface MyClass163Repository 
{

	public List<MyClass163> findAll () ;
	public List<MyClass163> findByCriteria (MyClass163Criteria myClass163Criteria) ;
	public MyClass163 findById (Long id) ;
	public MyClass163 save (MyClass163 myclass163) ;

}
