package big.services;

import big.domain.MyClass42;
import java.util.List;
import big.repositories.criteria.MyClass42Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass42Service 
{

	public List<MyClass42> findAll () ;
	public List<MyClass42> findByCriteria (MyClass42Criteria criteria) ;
	public MyClass42 findById (Long id) ;
	public MyClass42 save (MyClass42 myclass42) ;

}
