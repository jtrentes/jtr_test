package big.services;

import java.util.List;
import big.domain.MyClass25;
import big.repositories.criteria.MyClass25Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass25Service 
{

	public List<MyClass25> findAll () ;
	public List<MyClass25> findByCriteria (MyClass25Criteria criteria) ;
	public MyClass25 findById (Long id) ;
	public MyClass25 save (MyClass25 myclass25) ;

}
