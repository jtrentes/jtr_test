package big.services;

import big.domain.MyClass27;
import big.repositories.criteria.MyClass27Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass27Service 
{

	public List<MyClass27> findAll () ;
	public List<MyClass27> findByCriteria (MyClass27Criteria criteria) ;
	public MyClass27 findById (Long id) ;
	public MyClass27 save (MyClass27 myclass27) ;

}
