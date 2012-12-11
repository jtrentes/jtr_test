package big.services;

import big.domain.MyClass18;
import java.util.List;
import big.repositories.criteria.MyClass18Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass18Service 
{

	public List<MyClass18> findAll () ;
	public List<MyClass18> findByCriteria (MyClass18Criteria criteria) ;
	public MyClass18 findById (Long id) ;
	public MyClass18 save (MyClass18 myclass18) ;

}
