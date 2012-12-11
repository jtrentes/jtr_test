package big.repositories;

import java.util.List;
import big.domain.MyClass41;
import big.repositories.criteria.MyClass41Criteria;



public interface MyClass41Repository 
{

	public List<MyClass41> findAll () ;
	public List<MyClass41> findByCriteria (MyClass41Criteria myClass41Criteria) ;
	public MyClass41 findById (Long id) ;
	public MyClass41 save (MyClass41 myclass41) ;

}
