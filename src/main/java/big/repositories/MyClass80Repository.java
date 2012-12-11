package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass80Criteria;
import big.domain.MyClass80;



public interface MyClass80Repository 
{

	public List<MyClass80> findAll () ;
	public List<MyClass80> findByCriteria (MyClass80Criteria myClass80Criteria) ;
	public MyClass80 findById (Long id) ;
	public MyClass80 save (MyClass80 myclass80) ;

}
