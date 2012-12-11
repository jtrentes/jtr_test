package big.services;

import big.repositories.criteria.MyClass136Criteria;
import java.util.List;
import big.domain.MyClass136;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass136Service 
{

	public List<MyClass136> findAll () ;
	public List<MyClass136> findByCriteria (MyClass136Criteria criteria) ;
	public MyClass136 findById (Long id) ;
	public MyClass136 save (MyClass136 myclass136) ;

}
