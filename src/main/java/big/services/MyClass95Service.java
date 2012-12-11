package big.services;

import java.util.List;
import big.domain.MyClass95;
import big.repositories.criteria.MyClass95Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass95Service 
{

	public List<MyClass95> findAll () ;
	public List<MyClass95> findByCriteria (MyClass95Criteria criteria) ;
	public MyClass95 findById (Long id) ;
	public MyClass95 save (MyClass95 myclass95) ;

}
