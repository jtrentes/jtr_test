package big.services;

import big.repositories.criteria.MyClass158Criteria;
import big.domain.MyClass158;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass158Service 
{

	public List<MyClass158> findAll () ;
	public List<MyClass158> findByCriteria (MyClass158Criteria criteria) ;
	public MyClass158 findById (Long id) ;
	public MyClass158 save (MyClass158 myclass158) ;

}
