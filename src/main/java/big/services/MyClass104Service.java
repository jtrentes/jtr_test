package big.services;

import java.util.List;
import big.domain.MyClass104;
import big.repositories.criteria.MyClass104Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass104Service 
{

	public List<MyClass104> findAll () ;
	public List<MyClass104> findByCriteria (MyClass104Criteria criteria) ;
	public MyClass104 findById (Long id) ;
	public MyClass104 save (MyClass104 myclass104) ;

}
