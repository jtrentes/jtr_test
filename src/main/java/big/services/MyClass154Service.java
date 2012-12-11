package big.services;

import big.domain.MyClass154;
import big.repositories.criteria.MyClass154Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass154Service 
{

	public List<MyClass154> findAll () ;
	public List<MyClass154> findByCriteria (MyClass154Criteria criteria) ;
	public MyClass154 findById (Long id) ;
	public MyClass154 save (MyClass154 myclass154) ;

}
