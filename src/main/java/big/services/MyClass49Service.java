package big.services;

import big.repositories.criteria.MyClass49Criteria;
import java.util.List;
import big.domain.MyClass49;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass49Service 
{

	public List<MyClass49> findAll () ;
	public List<MyClass49> findByCriteria (MyClass49Criteria criteria) ;
	public MyClass49 findById (Long id) ;
	public MyClass49 save (MyClass49 myclass49) ;

}
