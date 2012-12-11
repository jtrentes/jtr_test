package big.services;

import big.domain.MyClass124;
import big.repositories.criteria.MyClass124Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass124Service 
{

	public List<MyClass124> findAll () ;
	public List<MyClass124> findByCriteria (MyClass124Criteria criteria) ;
	public MyClass124 findById (Long id) ;
	public MyClass124 save (MyClass124 myclass124) ;

}
