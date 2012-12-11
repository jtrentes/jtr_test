package big.services;

import big.domain.MyClass82;
import java.util.List;
import big.repositories.criteria.MyClass82Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass82Service 
{

	public List<MyClass82> findAll () ;
	public List<MyClass82> findByCriteria (MyClass82Criteria criteria) ;
	public MyClass82 findById (Long id) ;
	public MyClass82 save (MyClass82 myclass82) ;

}
