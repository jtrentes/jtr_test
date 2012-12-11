package big.services;

import big.domain.MyClass29;
import java.util.List;
import big.repositories.criteria.MyClass29Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass29Service 
{

	public List<MyClass29> findAll () ;
	public List<MyClass29> findByCriteria (MyClass29Criteria criteria) ;
	public MyClass29 findById (Long id) ;
	public MyClass29 save (MyClass29 myclass29) ;

}
