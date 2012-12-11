package big.services;

import big.domain.MyClass84;
import java.util.List;
import big.repositories.criteria.MyClass84Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass84Service 
{

	public List<MyClass84> findAll () ;
	public List<MyClass84> findByCriteria (MyClass84Criteria criteria) ;
	public MyClass84 findById (Long id) ;
	public MyClass84 save (MyClass84 myclass84) ;

}
