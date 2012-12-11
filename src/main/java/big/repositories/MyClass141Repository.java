package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass141Criteria;
import big.domain.MyClass141;



public interface MyClass141Repository 
{

	public List<MyClass141> findAll () ;
	public List<MyClass141> findByCriteria (MyClass141Criteria myClass141Criteria) ;
	public MyClass141 findById (Long id) ;
	public MyClass141 save (MyClass141 myclass141) ;

}
