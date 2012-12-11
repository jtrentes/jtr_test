package big.services;

import big.domain.MyClass17;
import big.repositories.criteria.MyClass17Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass17Service 
{

	public List<MyClass17> findAll () ;
	public List<MyClass17> findByCriteria (MyClass17Criteria criteria) ;
	public MyClass17 findById (Long id) ;
	public MyClass17 save (MyClass17 myclass17) ;

}
