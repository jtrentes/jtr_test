package big.services;

import big.domain.MyClass121;
import java.util.List;
import big.repositories.criteria.MyClass121Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass121Service 
{

	public List<MyClass121> findAll () ;
	public List<MyClass121> findByCriteria (MyClass121Criteria criteria) ;
	public MyClass121 findById (Long id) ;
	public MyClass121 save (MyClass121 myclass121) ;

}
