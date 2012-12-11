package big.services;

import java.util.List;
import big.repositories.criteria.MyClass140Criteria;
import big.domain.MyClass140;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass140Service 
{

	public List<MyClass140> findAll () ;
	public List<MyClass140> findByCriteria (MyClass140Criteria criteria) ;
	public MyClass140 findById (Long id) ;
	public MyClass140 save (MyClass140 myclass140) ;

}
