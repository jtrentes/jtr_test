package big.services;

import java.util.List;
import big.domain.MyClass119;
import big.repositories.criteria.MyClass119Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass119Service 
{

	public List<MyClass119> findAll () ;
	public List<MyClass119> findByCriteria (MyClass119Criteria criteria) ;
	public MyClass119 findById (Long id) ;
	public MyClass119 save (MyClass119 myclass119) ;

}
