package big.services;

import big.domain.MyClass63;
import java.util.List;
import big.repositories.criteria.MyClass63Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass63Service 
{

	public List<MyClass63> findAll () ;
	public List<MyClass63> findByCriteria (MyClass63Criteria criteria) ;
	public MyClass63 findById (Long id) ;
	public MyClass63 save (MyClass63 myclass63) ;

}
