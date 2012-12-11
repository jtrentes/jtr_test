package big.services;

import big.repositories.criteria.MyClass35Criteria;
import java.util.List;
import big.domain.MyClass35;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass35Service 
{

	public List<MyClass35> findAll () ;
	public List<MyClass35> findByCriteria (MyClass35Criteria criteria) ;
	public MyClass35 findById (Long id) ;
	public MyClass35 save (MyClass35 myclass35) ;

}
