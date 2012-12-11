package big.services;

import java.util.List;
import big.repositories.criteria.MyClass24Criteria;
import big.domain.MyClass24;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass24Service 
{

	public List<MyClass24> findAll () ;
	public List<MyClass24> findByCriteria (MyClass24Criteria criteria) ;
	public MyClass24 findById (Long id) ;
	public MyClass24 save (MyClass24 myclass24) ;

}
