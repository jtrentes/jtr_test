package big.services;

import java.util.List;
import big.domain.MyClass7;
import big.repositories.criteria.MyClass7Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass7Service 
{

	public List<MyClass7> findAll () ;
	public List<MyClass7> findByCriteria (MyClass7Criteria criteria) ;
	public MyClass7 findById (Long id) ;
	public MyClass7 save (MyClass7 myclass7) ;

}
