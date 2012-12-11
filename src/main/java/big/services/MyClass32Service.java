package big.services;

import big.domain.MyClass32;
import big.repositories.criteria.MyClass32Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass32Service 
{

	public List<MyClass32> findAll () ;
	public List<MyClass32> findByCriteria (MyClass32Criteria criteria) ;
	public MyClass32 findById (Long id) ;
	public MyClass32 save (MyClass32 myclass32) ;

}
