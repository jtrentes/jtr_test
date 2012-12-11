package big.services;

import java.util.List;
import big.domain.MyClass6;
import big.repositories.criteria.MyClass6Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass6Service 
{

	public List<MyClass6> findAll () ;
	public List<MyClass6> findByCriteria (MyClass6Criteria criteria) ;
	public MyClass6 findById (Long id) ;
	public MyClass6 save (MyClass6 myclass6) ;

}
