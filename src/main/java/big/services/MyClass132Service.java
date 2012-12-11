package big.services;

import big.repositories.criteria.MyClass132Criteria;
import java.util.List;
import big.domain.MyClass132;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass132Service 
{

	public List<MyClass132> findAll () ;
	public List<MyClass132> findByCriteria (MyClass132Criteria criteria) ;
	public MyClass132 findById (Long id) ;
	public MyClass132 save (MyClass132 myclass132) ;

}
