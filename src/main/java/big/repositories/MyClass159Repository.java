package big.repositories;

import big.domain.MyClass159;
import java.util.List;
import big.repositories.criteria.MyClass159Criteria;



public interface MyClass159Repository 
{

	public List<MyClass159> findAll () ;
	public List<MyClass159> findByCriteria (MyClass159Criteria myClass159Criteria) ;
	public MyClass159 findById (Long id) ;
	public MyClass159 save (MyClass159 myclass159) ;

}
