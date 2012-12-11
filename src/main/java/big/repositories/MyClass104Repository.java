package big.repositories;

import big.repositories.criteria.MyClass104Criteria;
import java.util.List;
import big.domain.MyClass104;



public interface MyClass104Repository 
{

	public List<MyClass104> findAll () ;
	public List<MyClass104> findByCriteria (MyClass104Criteria myClass104Criteria) ;
	public MyClass104 findById (Long id) ;
	public MyClass104 save (MyClass104 myclass104) ;

}
