package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClassCriteria;
import big.domain.MyClass;



public interface MyClassRepository 
{

	public List<MyClass> findAll () ;
	public List<MyClass> findByCriteria (MyClassCriteria myClassCriteria) ;
	public MyClass findById (Long id) ;
	public MyClass save (MyClass myclass) ;

}
