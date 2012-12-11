package big.services;

import big.repositories.criteria.MyClass56Criteria;
import java.util.List;
import big.domain.MyClass56;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass56Service 
{

	public List<MyClass56> findAll () ;
	public List<MyClass56> findByCriteria (MyClass56Criteria criteria) ;
	public MyClass56 findById (Long id) ;
	public MyClass56 save (MyClass56 myclass56) ;

}
