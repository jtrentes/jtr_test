package big.services;

import java.util.List;
import big.domain.MyClass50;
import big.repositories.criteria.MyClass50Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass50Service 
{

	public List<MyClass50> findAll () ;
	public List<MyClass50> findByCriteria (MyClass50Criteria criteria) ;
	public MyClass50 findById (Long id) ;
	public MyClass50 save (MyClass50 myclass50) ;

}
