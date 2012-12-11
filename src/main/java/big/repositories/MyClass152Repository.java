package big.repositories;

import big.repositories.criteria.MyClass152Criteria;
import java.util.List;
import big.domain.MyClass152;



public interface MyClass152Repository 
{

	public List<MyClass152> findAll () ;
	public List<MyClass152> findByCriteria (MyClass152Criteria myClass152Criteria) ;
	public MyClass152 findById (Long id) ;
	public MyClass152 save (MyClass152 myclass152) ;

}
