package big.services;

import big.repositories.criteria.MyClass120Criteria;
import java.util.List;
import big.domain.MyClass120;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass120Service 
{

	public List<MyClass120> findAll () ;
	public List<MyClass120> findByCriteria (MyClass120Criteria criteria) ;
	public MyClass120 findById (Long id) ;
	public MyClass120 save (MyClass120 myclass120) ;

}
