package big.services;

import java.util.List;
import big.repositories.criteria.MyClass90Criteria;
import big.domain.MyClass90;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass90Service 
{

	public List<MyClass90> findAll () ;
	public List<MyClass90> findByCriteria (MyClass90Criteria criteria) ;
	public MyClass90 findById (Long id) ;
	public MyClass90 save (MyClass90 myclass90) ;

}
