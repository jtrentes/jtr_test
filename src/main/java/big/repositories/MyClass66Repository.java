package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass66Criteria;
import big.domain.MyClass66;



public interface MyClass66Repository 
{

	public List<MyClass66> findAll () ;
	public List<MyClass66> findByCriteria (MyClass66Criteria myClass66Criteria) ;
	public MyClass66 findById (Long id) ;
	public MyClass66 save (MyClass66 myclass66) ;

}
