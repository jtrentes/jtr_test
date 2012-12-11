package big.services;

import java.util.List;
import big.domain.MyClass109;
import big.repositories.criteria.MyClass109Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass109Service 
{

	public List<MyClass109> findAll () ;
	public List<MyClass109> findByCriteria (MyClass109Criteria criteria) ;
	public MyClass109 findById (Long id) ;
	public MyClass109 save (MyClass109 myclass109) ;

}
