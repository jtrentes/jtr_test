package big.repositories;

import big.repositories.criteria.MyClass85Criteria;
import big.domain.MyClass85;
import java.util.List;



public interface MyClass85Repository 
{

	public List<MyClass85> findAll () ;
	public List<MyClass85> findByCriteria (MyClass85Criteria myClass85Criteria) ;
	public MyClass85 findById (Long id) ;
	public MyClass85 save (MyClass85 myclass85) ;

}
