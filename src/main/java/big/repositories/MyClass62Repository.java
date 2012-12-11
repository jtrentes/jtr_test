package big.repositories;

import java.util.List;
import big.domain.MyClass62;
import big.repositories.criteria.MyClass62Criteria;



public interface MyClass62Repository 
{

	public List<MyClass62> findAll () ;
	public List<MyClass62> findByCriteria (MyClass62Criteria myClass62Criteria) ;
	public MyClass62 findById (Long id) ;
	public MyClass62 save (MyClass62 myclass62) ;

}
