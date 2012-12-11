package big.services;

import java.util.List;
import big.repositories.criteria.MyClass48Criteria;
import big.domain.MyClass48;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass48Service 
{

	public List<MyClass48> findAll () ;
	public List<MyClass48> findByCriteria (MyClass48Criteria criteria) ;
	public MyClass48 findById (Long id) ;
	public MyClass48 save (MyClass48 myclass48) ;

}
