package big.services;

import java.util.List;
import big.domain.MyClass75;
import big.repositories.criteria.MyClass75Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass75Service 
{

	public List<MyClass75> findAll () ;
	public List<MyClass75> findByCriteria (MyClass75Criteria criteria) ;
	public MyClass75 findById (Long id) ;
	public MyClass75 save (MyClass75 myclass75) ;

}
