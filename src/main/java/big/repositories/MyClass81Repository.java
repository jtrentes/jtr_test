package big.repositories;

import java.util.List;
import big.domain.MyClass81;
import big.repositories.criteria.MyClass81Criteria;



public interface MyClass81Repository 
{

	public List<MyClass81> findAll () ;
	public List<MyClass81> findByCriteria (MyClass81Criteria myClass81Criteria) ;
	public MyClass81 findById (Long id) ;
	public MyClass81 save (MyClass81 myclass81) ;

}
