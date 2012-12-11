package big.repositories;

import big.domain.MyClass61;
import big.repositories.criteria.MyClass61Criteria;
import java.util.List;



public interface MyClass61Repository 
{

	public List<MyClass61> findAll () ;
	public List<MyClass61> findByCriteria (MyClass61Criteria myClass61Criteria) ;
	public MyClass61 findById (Long id) ;
	public MyClass61 save (MyClass61 myclass61) ;

}
