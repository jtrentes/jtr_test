package big.services;

import big.repositories.criteria.MyClass122Criteria;
import java.util.List;
import big.domain.MyClass122;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass122Service 
{

	public List<MyClass122> findAll () ;
	public List<MyClass122> findByCriteria (MyClass122Criteria criteria) ;
	public MyClass122 findById (Long id) ;
	public MyClass122 save (MyClass122 myclass122) ;

}
