package big.services;

import big.domain.MyClass144;
import java.util.List;
import big.repositories.criteria.MyClass144Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass144Service 
{

	public List<MyClass144> findAll () ;
	public List<MyClass144> findByCriteria (MyClass144Criteria criteria) ;
	public MyClass144 findById (Long id) ;
	public MyClass144 save (MyClass144 myclass144) ;

}
