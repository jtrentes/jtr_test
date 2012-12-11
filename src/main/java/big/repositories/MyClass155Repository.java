package big.repositories;

import big.domain.MyClass155;
import java.util.List;
import big.repositories.criteria.MyClass155Criteria;



public interface MyClass155Repository 
{

	public List<MyClass155> findAll () ;
	public List<MyClass155> findByCriteria (MyClass155Criteria myClass155Criteria) ;
	public MyClass155 findById (Long id) ;
	public MyClass155 save (MyClass155 myclass155) ;

}
