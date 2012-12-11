package big.services;

import java.util.List;
import big.domain.MyClass73;
import big.repositories.criteria.MyClass73Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass73Service 
{

	public List<MyClass73> findAll () ;
	public List<MyClass73> findByCriteria (MyClass73Criteria criteria) ;
	public MyClass73 findById (Long id) ;
	public MyClass73 save (MyClass73 myclass73) ;

}
