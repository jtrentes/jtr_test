package big.services;

import big.repositories.criteria.MyClass126Criteria;
import java.util.List;
import big.domain.MyClass126;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass126Service 
{

	public List<MyClass126> findAll () ;
	public List<MyClass126> findByCriteria (MyClass126Criteria criteria) ;
	public MyClass126 findById (Long id) ;
	public MyClass126 save (MyClass126 myclass126) ;

}
