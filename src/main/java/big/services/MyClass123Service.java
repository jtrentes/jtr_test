package big.services;

import java.util.List;
import big.repositories.criteria.MyClass123Criteria;
import big.domain.MyClass123;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass123Service 
{

	public List<MyClass123> findAll () ;
	public List<MyClass123> findByCriteria (MyClass123Criteria criteria) ;
	public MyClass123 findById (Long id) ;
	public MyClass123 save (MyClass123 myclass123) ;

}
