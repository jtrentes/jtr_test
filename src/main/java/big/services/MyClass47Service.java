package big.services;

import big.repositories.criteria.MyClass47Criteria;
import java.util.List;
import big.domain.MyClass47;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass47Service 
{

	public List<MyClass47> findAll () ;
	public List<MyClass47> findByCriteria (MyClass47Criteria criteria) ;
	public MyClass47 findById (Long id) ;
	public MyClass47 save (MyClass47 myclass47) ;

}
