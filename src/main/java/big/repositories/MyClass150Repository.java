package big.repositories;

import big.domain.MyClass150;
import java.util.List;
import big.repositories.criteria.MyClass150Criteria;



public interface MyClass150Repository 
{

	public List<MyClass150> findAll () ;
	public List<MyClass150> findByCriteria (MyClass150Criteria myClass150Criteria) ;
	public MyClass150 findById (Long id) ;
	public MyClass150 save (MyClass150 myclass150) ;

}
