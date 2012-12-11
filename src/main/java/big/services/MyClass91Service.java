package big.services;

import java.util.List;
import big.repositories.criteria.MyClass91Criteria;
import big.domain.MyClass91;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass91Service 
{

	public List<MyClass91> findAll () ;
	public List<MyClass91> findByCriteria (MyClass91Criteria criteria) ;
	public MyClass91 findById (Long id) ;
	public MyClass91 save (MyClass91 myclass91) ;

}
