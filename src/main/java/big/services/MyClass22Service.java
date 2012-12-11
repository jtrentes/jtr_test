package big.services;

import big.domain.MyClass22;
import big.repositories.criteria.MyClass22Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass22Service 
{

	public List<MyClass22> findAll () ;
	public List<MyClass22> findByCriteria (MyClass22Criteria criteria) ;
	public MyClass22 findById (Long id) ;
	public MyClass22 save (MyClass22 myclass22) ;

}
