package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass5Criteria;
import big.domain.MyClass5;



public interface MyClass5Repository 
{

	public List<MyClass5> findAll () ;
	public List<MyClass5> findByCriteria (MyClass5Criteria myClass5Criteria) ;
	public MyClass5 findById (Long id) ;
	public MyClass5 save (MyClass5 myclass5) ;

}
