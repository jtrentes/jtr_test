package big.services;

import java.util.List;
import big.repositories.criteria.MyClass53Criteria;
import big.domain.MyClass53;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass53Service 
{

	public List<MyClass53> findAll () ;
	public List<MyClass53> findByCriteria (MyClass53Criteria criteria) ;
	public MyClass53 findById (Long id) ;
	public MyClass53 save (MyClass53 myclass53) ;

}
