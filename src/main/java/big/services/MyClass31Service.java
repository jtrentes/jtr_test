package big.services;

import java.util.List;
import big.repositories.criteria.MyClass31Criteria;
import big.domain.MyClass31;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass31Service 
{

	public List<MyClass31> findAll () ;
	public List<MyClass31> findByCriteria (MyClass31Criteria criteria) ;
	public MyClass31 findById (Long id) ;
	public MyClass31 save (MyClass31 myclass31) ;

}
