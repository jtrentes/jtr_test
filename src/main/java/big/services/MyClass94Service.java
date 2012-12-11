package big.services;

import big.repositories.criteria.MyClass94Criteria;
import java.util.List;
import big.domain.MyClass94;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass94Service 
{

	public List<MyClass94> findAll () ;
	public List<MyClass94> findByCriteria (MyClass94Criteria criteria) ;
	public MyClass94 findById (Long id) ;
	public MyClass94 save (MyClass94 myclass94) ;

}
