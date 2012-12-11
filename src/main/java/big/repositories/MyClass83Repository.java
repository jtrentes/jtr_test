package big.repositories;

import big.domain.MyClass83;
import big.repositories.criteria.MyClass83Criteria;
import java.util.List;



public interface MyClass83Repository 
{

	public List<MyClass83> findAll () ;
	public List<MyClass83> findByCriteria (MyClass83Criteria myClass83Criteria) ;
	public MyClass83 findById (Long id) ;
	public MyClass83 save (MyClass83 myclass83) ;

}
