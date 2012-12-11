package big.services;

import java.util.List;
import big.repositories.criteria.MyClass37Criteria;
import big.domain.MyClass37;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass37Service 
{

	public List<MyClass37> findAll () ;
	public List<MyClass37> findByCriteria (MyClass37Criteria criteria) ;
	public MyClass37 findById (Long id) ;
	public MyClass37 save (MyClass37 myclass37) ;

}
