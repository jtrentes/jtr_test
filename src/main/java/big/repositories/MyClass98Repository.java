package big.repositories;

import big.domain.MyClass98;
import java.util.List;
import big.repositories.criteria.MyClass98Criteria;



public interface MyClass98Repository 
{

	public List<MyClass98> findAll () ;
	public List<MyClass98> findByCriteria (MyClass98Criteria myClass98Criteria) ;
	public MyClass98 findById (Long id) ;
	public MyClass98 save (MyClass98 myclass98) ;

}
