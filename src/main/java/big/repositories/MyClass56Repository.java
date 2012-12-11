package big.repositories;

import big.repositories.criteria.MyClass56Criteria;
import big.domain.MyClass56;
import java.util.List;



public interface MyClass56Repository 
{

	public List<MyClass56> findAll () ;
	public List<MyClass56> findByCriteria (MyClass56Criteria myClass56Criteria) ;
	public MyClass56 findById (Long id) ;
	public MyClass56 save (MyClass56 myclass56) ;

}
