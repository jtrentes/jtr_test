package big.services;

import java.util.List;
import big.domain.MyClass110;
import big.repositories.criteria.MyClass110Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass110Service 
{

	public List<MyClass110> findAll () ;
	public List<MyClass110> findByCriteria (MyClass110Criteria criteria) ;
	public MyClass110 findById (Long id) ;
	public MyClass110 save (MyClass110 myclass110) ;

}
