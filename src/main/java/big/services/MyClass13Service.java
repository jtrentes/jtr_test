package big.services;

import big.repositories.criteria.MyClass13Criteria;
import big.domain.MyClass13;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass13Service 
{

	public List<MyClass13> findAll () ;
	public List<MyClass13> findByCriteria (MyClass13Criteria criteria) ;
	public MyClass13 findById (Long id) ;
	public MyClass13 save (MyClass13 myclass13) ;

}
