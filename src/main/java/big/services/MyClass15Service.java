package big.services;

import java.util.List;
import big.domain.MyClass15;
import big.repositories.criteria.MyClass15Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass15Service 
{

	public List<MyClass15> findAll () ;
	public List<MyClass15> findByCriteria (MyClass15Criteria criteria) ;
	public MyClass15 findById (Long id) ;
	public MyClass15 save (MyClass15 myclass15) ;

}
