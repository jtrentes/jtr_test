package big.services;

import big.domain.MyClass61;
import java.util.List;
import big.repositories.criteria.MyClass61Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass61Service 
{

	public List<MyClass61> findAll () ;
	public List<MyClass61> findByCriteria (MyClass61Criteria criteria) ;
	public MyClass61 findById (Long id) ;
	public MyClass61 save (MyClass61 myclass61) ;

}
