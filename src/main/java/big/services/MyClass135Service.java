package big.services;

import java.util.List;
import big.domain.MyClass135;
import big.repositories.criteria.MyClass135Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass135Service 
{

	public List<MyClass135> findAll () ;
	public List<MyClass135> findByCriteria (MyClass135Criteria criteria) ;
	public MyClass135 findById (Long id) ;
	public MyClass135 save (MyClass135 myclass135) ;

}
