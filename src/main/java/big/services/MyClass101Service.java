package big.services;

import big.domain.MyClass101;
import java.util.List;
import big.repositories.criteria.MyClass101Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass101Service 
{

	public List<MyClass101> findAll () ;
	public List<MyClass101> findByCriteria (MyClass101Criteria criteria) ;
	public MyClass101 findById (Long id) ;
	public MyClass101 save (MyClass101 myclass101) ;

}
