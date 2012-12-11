package big.repositories;

import big.domain.MyClass115;
import big.repositories.criteria.MyClass115Criteria;
import java.util.List;



public interface MyClass115Repository 
{

	public List<MyClass115> findAll () ;
	public List<MyClass115> findByCriteria (MyClass115Criteria myClass115Criteria) ;
	public MyClass115 findById (Long id) ;
	public MyClass115 save (MyClass115 myclass115) ;

}
