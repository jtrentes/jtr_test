package big.services;

import big.domain.MyClass79;
import java.util.List;
import big.repositories.criteria.MyClass79Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass79Service 
{

	public List<MyClass79> findAll () ;
	public List<MyClass79> findByCriteria (MyClass79Criteria criteria) ;
	public MyClass79 findById (Long id) ;
	public MyClass79 save (MyClass79 myclass79) ;

}
