package big.services;

import java.util.List;
import big.repositories.criteria.MyClass96Criteria;
import big.domain.MyClass96;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass96Service 
{

	public List<MyClass96> findAll () ;
	public List<MyClass96> findByCriteria (MyClass96Criteria criteria) ;
	public MyClass96 findById (Long id) ;
	public MyClass96 save (MyClass96 myclass96) ;

}
