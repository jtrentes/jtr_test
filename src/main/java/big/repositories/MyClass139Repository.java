package big.repositories;

import java.util.List;
import big.domain.MyClass139;
import big.repositories.criteria.MyClass139Criteria;



public interface MyClass139Repository 
{

	public List<MyClass139> findAll () ;
	public List<MyClass139> findByCriteria (MyClass139Criteria myClass139Criteria) ;
	public MyClass139 findById (Long id) ;
	public MyClass139 save (MyClass139 myclass139) ;

}
