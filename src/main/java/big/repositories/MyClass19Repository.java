package big.repositories;

import java.util.List;
import big.domain.MyClass19;
import big.repositories.criteria.MyClass19Criteria;



public interface MyClass19Repository 
{

	public List<MyClass19> findAll () ;
	public List<MyClass19> findByCriteria (MyClass19Criteria myClass19Criteria) ;
	public MyClass19 findById (Long id) ;
	public MyClass19 save (MyClass19 myclass19) ;

}
