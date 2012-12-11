package big.services;

import big.domain.MyClass97;
import big.repositories.criteria.MyClass97Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass97Service 
{

	public List<MyClass97> findAll () ;
	public List<MyClass97> findByCriteria (MyClass97Criteria criteria) ;
	public MyClass97 findById (Long id) ;
	public MyClass97 save (MyClass97 myclass97) ;

}
