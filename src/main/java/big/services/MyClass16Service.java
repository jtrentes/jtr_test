package big.services;

import big.domain.MyClass16;
import java.util.List;
import big.repositories.criteria.MyClass16Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass16Service 
{

	public List<MyClass16> findAll () ;
	public List<MyClass16> findByCriteria (MyClass16Criteria criteria) ;
	public MyClass16 findById (Long id) ;
	public MyClass16 save (MyClass16 myclass16) ;

}
