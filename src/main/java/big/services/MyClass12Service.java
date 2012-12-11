package big.services;

import big.repositories.criteria.MyClass12Criteria;
import big.domain.MyClass12;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass12Service 
{

	public List<MyClass12> findAll () ;
	public List<MyClass12> findByCriteria (MyClass12Criteria criteria) ;
	public MyClass12 findById (Long id) ;
	public MyClass12 save (MyClass12 myclass12) ;

}
