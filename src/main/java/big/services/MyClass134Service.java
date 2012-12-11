package big.services;

import big.domain.MyClass134;
import java.util.List;
import big.repositories.criteria.MyClass134Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass134Service 
{

	public List<MyClass134> findAll () ;
	public List<MyClass134> findByCriteria (MyClass134Criteria criteria) ;
	public MyClass134 findById (Long id) ;
	public MyClass134 save (MyClass134 myclass134) ;

}
