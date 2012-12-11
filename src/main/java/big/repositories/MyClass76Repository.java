package big.repositories;

import java.util.List;
import big.domain.MyClass76;
import big.repositories.criteria.MyClass76Criteria;



public interface MyClass76Repository 
{

	public List<MyClass76> findAll () ;
	public List<MyClass76> findByCriteria (MyClass76Criteria myClass76Criteria) ;
	public MyClass76 findById (Long id) ;
	public MyClass76 save (MyClass76 myclass76) ;

}
