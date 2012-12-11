package big.services;

import big.repositories.criteria.MyClass26Criteria;
import big.domain.MyClass26;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass26Service 
{

	public List<MyClass26> findAll () ;
	public List<MyClass26> findByCriteria (MyClass26Criteria criteria) ;
	public MyClass26 findById (Long id) ;
	public MyClass26 save (MyClass26 myclass26) ;

}
