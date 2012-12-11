package big.services;

import java.util.List;
import big.repositories.criteria.MyClass103Criteria;
import big.domain.MyClass103;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass103Service 
{

	public List<MyClass103> findAll () ;
	public List<MyClass103> findByCriteria (MyClass103Criteria criteria) ;
	public MyClass103 findById (Long id) ;
	public MyClass103 save (MyClass103 myclass103) ;

}
