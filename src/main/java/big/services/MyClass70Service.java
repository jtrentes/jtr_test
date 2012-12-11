package big.services;

import java.util.List;
import big.domain.MyClass70;
import big.repositories.criteria.MyClass70Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass70Service 
{

	public List<MyClass70> findAll () ;
	public List<MyClass70> findByCriteria (MyClass70Criteria criteria) ;
	public MyClass70 findById (Long id) ;
	public MyClass70 save (MyClass70 myclass70) ;

}
