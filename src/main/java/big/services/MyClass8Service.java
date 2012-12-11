package big.services;

import big.repositories.criteria.MyClass8Criteria;
import java.util.List;
import big.domain.MyClass8;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass8Service 
{

	public List<MyClass8> findAll () ;
	public List<MyClass8> findByCriteria (MyClass8Criteria criteria) ;
	public MyClass8 findById (Long id) ;
	public MyClass8 save (MyClass8 myclass8) ;

}
