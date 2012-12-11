package big.services;

import big.domain.MyClass44;
import big.repositories.criteria.MyClass44Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass44Service 
{

	public List<MyClass44> findAll () ;
	public List<MyClass44> findByCriteria (MyClass44Criteria criteria) ;
	public MyClass44 findById (Long id) ;
	public MyClass44 save (MyClass44 myclass44) ;

}
