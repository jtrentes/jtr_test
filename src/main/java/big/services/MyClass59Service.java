package big.services;

import big.domain.MyClass59;
import java.util.List;
import big.repositories.criteria.MyClass59Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass59Service 
{

	public List<MyClass59> findAll () ;
	public List<MyClass59> findByCriteria (MyClass59Criteria criteria) ;
	public MyClass59 findById (Long id) ;
	public MyClass59 save (MyClass59 myclass59) ;

}
