package big.services;

import java.util.List;
import big.repositories.criteria.MyClassCriteria;
import big.domain.MyClass;
import org.springframework.transaction.annotation.Transactional;



public interface MyClassService 
{

	public List<MyClass> findAll () ;
	public List<MyClass> findByCriteria (MyClassCriteria criteria) ;
	public MyClass findById (Long id) ;
	public MyClass save (MyClass myclass) ;

}
