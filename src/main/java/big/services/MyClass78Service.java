package big.services;

import big.repositories.criteria.MyClass78Criteria;
import big.domain.MyClass78;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass78Service 
{

	public List<MyClass78> findAll () ;
	public List<MyClass78> findByCriteria (MyClass78Criteria criteria) ;
	public MyClass78 findById (Long id) ;
	public MyClass78 save (MyClass78 myclass78) ;

}
