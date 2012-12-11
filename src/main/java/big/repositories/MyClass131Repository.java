package big.repositories;

import java.util.List;
import big.domain.MyClass131;
import big.repositories.criteria.MyClass131Criteria;



public interface MyClass131Repository 
{

	public List<MyClass131> findAll () ;
	public List<MyClass131> findByCriteria (MyClass131Criteria myClass131Criteria) ;
	public MyClass131 findById (Long id) ;
	public MyClass131 save (MyClass131 myclass131) ;

}
