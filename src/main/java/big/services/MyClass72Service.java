package big.services;

import big.domain.MyClass72;
import java.util.List;
import big.repositories.criteria.MyClass72Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass72Service 
{

	public List<MyClass72> findAll () ;
	public List<MyClass72> findByCriteria (MyClass72Criteria criteria) ;
	public MyClass72 findById (Long id) ;
	public MyClass72 save (MyClass72 myclass72) ;

}
