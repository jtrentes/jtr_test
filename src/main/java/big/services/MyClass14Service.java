package big.services;

import big.repositories.criteria.MyClass14Criteria;
import big.domain.MyClass14;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass14Service 
{

	public List<MyClass14> findAll () ;
	public List<MyClass14> findByCriteria (MyClass14Criteria criteria) ;
	public MyClass14 findById (Long id) ;
	public MyClass14 save (MyClass14 myclass14) ;

}
