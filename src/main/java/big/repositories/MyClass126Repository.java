package big.repositories;

import big.repositories.criteria.MyClass126Criteria;
import big.domain.MyClass126;
import java.util.List;



public interface MyClass126Repository 
{

	public List<MyClass126> findAll () ;
	public List<MyClass126> findByCriteria (MyClass126Criteria myClass126Criteria) ;
	public MyClass126 findById (Long id) ;
	public MyClass126 save (MyClass126 myclass126) ;

}
