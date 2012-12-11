package big.services;

import big.domain.MyClass54;
import big.repositories.criteria.MyClass54Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass54Service 
{

	public List<MyClass54> findAll () ;
	public List<MyClass54> findByCriteria (MyClass54Criteria criteria) ;
	public MyClass54 findById (Long id) ;
	public MyClass54 save (MyClass54 myclass54) ;

}
