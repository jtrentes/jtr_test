package big.services;

import big.repositories.criteria.MyClass149Criteria;
import java.util.List;
import big.domain.MyClass149;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass149Service 
{

	public List<MyClass149> findAll () ;
	public List<MyClass149> findByCriteria (MyClass149Criteria criteria) ;
	public MyClass149 findById (Long id) ;
	public MyClass149 save (MyClass149 myclass149) ;

}
