package big.repositories;

import big.domain.MyClass86;
import big.repositories.criteria.MyClass86Criteria;
import java.util.List;



public interface MyClass86Repository 
{

	public List<MyClass86> findAll () ;
	public List<MyClass86> findByCriteria (MyClass86Criteria myClass86Criteria) ;
	public MyClass86 findById (Long id) ;
	public MyClass86 save (MyClass86 myclass86) ;

}
