package big.services;

import big.domain.MyClass51;
import big.repositories.criteria.MyClass51Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass51Service 
{

	public List<MyClass51> findAll () ;
	public List<MyClass51> findByCriteria (MyClass51Criteria criteria) ;
	public MyClass51 findById (Long id) ;
	public MyClass51 save (MyClass51 myclass51) ;

}
