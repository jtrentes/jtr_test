package big.services;

import big.repositories.criteria.MyClass127Criteria;
import big.domain.MyClass127;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass127Service 
{

	public List<MyClass127> findAll () ;
	public List<MyClass127> findByCriteria (MyClass127Criteria criteria) ;
	public MyClass127 findById (Long id) ;
	public MyClass127 save (MyClass127 myclass127) ;

}
