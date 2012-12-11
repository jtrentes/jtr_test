package big.services;

import java.util.List;
import big.domain.MyClass99;
import big.repositories.criteria.MyClass99Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass99Service 
{

	public List<MyClass99> findAll () ;
	public List<MyClass99> findByCriteria (MyClass99Criteria criteria) ;
	public MyClass99 findById (Long id) ;
	public MyClass99 save (MyClass99 myclass99) ;

}
