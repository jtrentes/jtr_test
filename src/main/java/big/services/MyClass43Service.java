package big.services;

import big.repositories.criteria.MyClass43Criteria;
import big.domain.MyClass43;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass43Service 
{

	public List<MyClass43> findAll () ;
	public List<MyClass43> findByCriteria (MyClass43Criteria criteria) ;
	public MyClass43 findById (Long id) ;
	public MyClass43 save (MyClass43 myclass43) ;

}
