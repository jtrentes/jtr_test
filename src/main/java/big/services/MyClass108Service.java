package big.services;

import big.domain.MyClass108;
import big.repositories.criteria.MyClass108Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass108Service 
{

	public List<MyClass108> findAll () ;
	public List<MyClass108> findByCriteria (MyClass108Criteria criteria) ;
	public MyClass108 findById (Long id) ;
	public MyClass108 save (MyClass108 myclass108) ;

}
