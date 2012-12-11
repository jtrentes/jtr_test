package big.services;

import big.repositories.criteria.MyClass46Criteria;
import java.util.List;
import big.domain.MyClass46;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass46Service 
{

	public List<MyClass46> findAll () ;
	public List<MyClass46> findByCriteria (MyClass46Criteria criteria) ;
	public MyClass46 findById (Long id) ;
	public MyClass46 save (MyClass46 myclass46) ;

}
