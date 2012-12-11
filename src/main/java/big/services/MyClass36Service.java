package big.services;

import java.util.List;
import big.repositories.criteria.MyClass36Criteria;
import big.domain.MyClass36;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass36Service 
{

	public List<MyClass36> findAll () ;
	public List<MyClass36> findByCriteria (MyClass36Criteria criteria) ;
	public MyClass36 findById (Long id) ;
	public MyClass36 save (MyClass36 myclass36) ;

}
