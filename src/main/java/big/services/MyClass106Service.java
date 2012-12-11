package big.services;

import java.util.List;
import big.domain.MyClass106;
import big.repositories.criteria.MyClass106Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass106Service 
{

	public List<MyClass106> findAll () ;
	public List<MyClass106> findByCriteria (MyClass106Criteria criteria) ;
	public MyClass106 findById (Long id) ;
	public MyClass106 save (MyClass106 myclass106) ;

}
