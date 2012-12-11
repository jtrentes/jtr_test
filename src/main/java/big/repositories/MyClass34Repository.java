package big.repositories;

import big.repositories.criteria.MyClass34Criteria;
import big.domain.MyClass34;
import java.util.List;



public interface MyClass34Repository 
{

	public List<MyClass34> findAll () ;
	public List<MyClass34> findByCriteria (MyClass34Criteria myClass34Criteria) ;
	public MyClass34 findById (Long id) ;
	public MyClass34 save (MyClass34 myclass34) ;

}
