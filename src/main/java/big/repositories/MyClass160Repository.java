package big.repositories;

import big.repositories.criteria.MyClass160Criteria;
import java.util.List;
import big.domain.MyClass160;



public interface MyClass160Repository 
{

	public List<MyClass160> findAll () ;
	public List<MyClass160> findByCriteria (MyClass160Criteria myClass160Criteria) ;
	public MyClass160 findById (Long id) ;
	public MyClass160 save (MyClass160 myclass160) ;

}
