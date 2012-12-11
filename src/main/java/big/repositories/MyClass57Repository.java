package big.repositories;

import big.domain.MyClass57;
import big.repositories.criteria.MyClass57Criteria;
import java.util.List;



public interface MyClass57Repository 
{

	public List<MyClass57> findAll () ;
	public List<MyClass57> findByCriteria (MyClass57Criteria myClass57Criteria) ;
	public MyClass57 findById (Long id) ;
	public MyClass57 save (MyClass57 myclass57) ;

}
