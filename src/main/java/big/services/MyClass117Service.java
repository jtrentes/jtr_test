package big.services;

import java.util.List;
import big.domain.MyClass117;
import big.repositories.criteria.MyClass117Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass117Service 
{

	public List<MyClass117> findAll () ;
	public List<MyClass117> findByCriteria (MyClass117Criteria criteria) ;
	public MyClass117 findById (Long id) ;
	public MyClass117 save (MyClass117 myclass117) ;

}
