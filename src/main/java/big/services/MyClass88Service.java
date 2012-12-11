package big.services;

import java.util.List;
import big.domain.MyClass88;
import big.repositories.criteria.MyClass88Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass88Service 
{

	public List<MyClass88> findAll () ;
	public List<MyClass88> findByCriteria (MyClass88Criteria criteria) ;
	public MyClass88 findById (Long id) ;
	public MyClass88 save (MyClass88 myclass88) ;

}
