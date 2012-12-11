package big.repositories;

import big.domain.MyClass118;
import big.repositories.criteria.MyClass118Criteria;
import java.util.List;



public interface MyClass118Repository 
{

	public List<MyClass118> findAll () ;
	public List<MyClass118> findByCriteria (MyClass118Criteria myClass118Criteria) ;
	public MyClass118 findById (Long id) ;
	public MyClass118 save (MyClass118 myclass118) ;

}
