package big.services;

import big.repositories.criteria.MyClass69Criteria;
import big.domain.MyClass69;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass69Service 
{

	public List<MyClass69> findAll () ;
	public List<MyClass69> findByCriteria (MyClass69Criteria criteria) ;
	public MyClass69 findById (Long id) ;
	public MyClass69 save (MyClass69 myclass69) ;

}
