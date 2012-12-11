package big.repositories;

import big.domain.MyClass10;
import big.repositories.criteria.MyClass10Criteria;
import java.util.List;



public interface MyClass10Repository 
{

	public List<MyClass10> findAll () ;
	public List<MyClass10> findByCriteria (MyClass10Criteria myClass10Criteria) ;
	public MyClass10 findById (Long id) ;
	public MyClass10 save (MyClass10 myclass10) ;

}
