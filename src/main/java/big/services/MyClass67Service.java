package big.services;

import java.util.List;
import big.domain.MyClass67;
import big.repositories.criteria.MyClass67Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass67Service 
{

	public List<MyClass67> findAll () ;
	public List<MyClass67> findByCriteria (MyClass67Criteria criteria) ;
	public MyClass67 findById (Long id) ;
	public MyClass67 save (MyClass67 myclass67) ;

}
