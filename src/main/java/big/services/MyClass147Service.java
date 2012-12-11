package big.services;

import big.repositories.criteria.MyClass147Criteria;
import java.util.List;
import big.domain.MyClass147;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass147Service 
{

	public List<MyClass147> findAll () ;
	public List<MyClass147> findByCriteria (MyClass147Criteria criteria) ;
	public MyClass147 findById (Long id) ;
	public MyClass147 save (MyClass147 myclass147) ;

}
