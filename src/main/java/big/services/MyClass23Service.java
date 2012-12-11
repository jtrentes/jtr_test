package big.services;

import big.repositories.criteria.MyClass23Criteria;
import big.domain.MyClass23;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass23Service 
{

	public List<MyClass23> findAll () ;
	public List<MyClass23> findByCriteria (MyClass23Criteria criteria) ;
	public MyClass23 findById (Long id) ;
	public MyClass23 save (MyClass23 myclass23) ;

}
