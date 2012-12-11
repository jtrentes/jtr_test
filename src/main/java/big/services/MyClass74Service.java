package big.services;

import big.repositories.criteria.MyClass74Criteria;
import java.util.List;
import big.domain.MyClass74;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass74Service 
{

	public List<MyClass74> findAll () ;
	public List<MyClass74> findByCriteria (MyClass74Criteria criteria) ;
	public MyClass74 findById (Long id) ;
	public MyClass74 save (MyClass74 myclass74) ;

}
