package big.repositories;

import big.domain.MyClass107;
import java.util.List;
import big.repositories.criteria.MyClass107Criteria;



public interface MyClass107Repository 
{

	public List<MyClass107> findAll () ;
	public List<MyClass107> findByCriteria (MyClass107Criteria myClass107Criteria) ;
	public MyClass107 findById (Long id) ;
	public MyClass107 save (MyClass107 myclass107) ;

}
