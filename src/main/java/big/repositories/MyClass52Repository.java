package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass52Criteria;
import big.domain.MyClass52;



public interface MyClass52Repository 
{

	public List<MyClass52> findAll () ;
	public List<MyClass52> findByCriteria (MyClass52Criteria myClass52Criteria) ;
	public MyClass52 findById (Long id) ;
	public MyClass52 save (MyClass52 myclass52) ;

}
