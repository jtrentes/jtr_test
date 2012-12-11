package big.repositories;

import big.domain.MyClass112;
import java.util.List;
import big.repositories.criteria.MyClass112Criteria;



public interface MyClass112Repository 
{

	public List<MyClass112> findAll () ;
	public List<MyClass112> findByCriteria (MyClass112Criteria myClass112Criteria) ;
	public MyClass112 findById (Long id) ;
	public MyClass112 save (MyClass112 myclass112) ;

}
