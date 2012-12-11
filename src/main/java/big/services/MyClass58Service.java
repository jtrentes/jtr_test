package big.services;

import java.util.List;
import big.domain.MyClass58;
import big.repositories.criteria.MyClass58Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass58Service 
{

	public List<MyClass58> findAll () ;
	public List<MyClass58> findByCriteria (MyClass58Criteria criteria) ;
	public MyClass58 findById (Long id) ;
	public MyClass58 save (MyClass58 myclass58) ;

}
