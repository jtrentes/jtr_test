package big.services;

import java.util.List;
import big.domain.MyClass146;
import big.repositories.criteria.MyClass146Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass146Service 
{

	public List<MyClass146> findAll () ;
	public List<MyClass146> findByCriteria (MyClass146Criteria criteria) ;
	public MyClass146 findById (Long id) ;
	public MyClass146 save (MyClass146 myclass146) ;

}
