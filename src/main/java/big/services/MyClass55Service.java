package big.services;

import big.domain.MyClass55;
import big.repositories.criteria.MyClass55Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass55Service 
{

	public List<MyClass55> findAll () ;
	public List<MyClass55> findByCriteria (MyClass55Criteria criteria) ;
	public MyClass55 findById (Long id) ;
	public MyClass55 save (MyClass55 myclass55) ;

}
