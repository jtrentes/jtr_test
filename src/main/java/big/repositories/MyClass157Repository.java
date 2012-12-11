package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass157Criteria;
import big.domain.MyClass157;



public interface MyClass157Repository 
{

	public List<MyClass157> findAll () ;
	public List<MyClass157> findByCriteria (MyClass157Criteria myClass157Criteria) ;
	public MyClass157 findById (Long id) ;
	public MyClass157 save (MyClass157 myclass157) ;

}
