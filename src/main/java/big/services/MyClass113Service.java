package big.services;

import big.domain.MyClass113;
import big.repositories.criteria.MyClass113Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass113Service 
{

	public List<MyClass113> findAll () ;
	public List<MyClass113> findByCriteria (MyClass113Criteria criteria) ;
	public MyClass113 findById (Long id) ;
	public MyClass113 save (MyClass113 myclass113) ;

}
