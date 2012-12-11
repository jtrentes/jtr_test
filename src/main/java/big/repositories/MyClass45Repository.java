package big.repositories;

import big.domain.MyClass45;
import big.repositories.criteria.MyClass45Criteria;
import java.util.List;



public interface MyClass45Repository 
{

	public List<MyClass45> findAll () ;
	public List<MyClass45> findByCriteria (MyClass45Criteria myClass45Criteria) ;
	public MyClass45 findById (Long id) ;
	public MyClass45 save (MyClass45 myclass45) ;

}
