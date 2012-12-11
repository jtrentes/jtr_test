package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass92Criteria;
import big.domain.MyClass92;



public interface MyClass92Repository 
{

	public List<MyClass92> findAll () ;
	public List<MyClass92> findByCriteria (MyClass92Criteria myClass92Criteria) ;
	public MyClass92 findById (Long id) ;
	public MyClass92 save (MyClass92 myclass92) ;

}
