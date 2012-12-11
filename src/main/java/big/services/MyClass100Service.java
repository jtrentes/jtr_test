package big.services;

import big.repositories.criteria.MyClass100Criteria;
import java.util.List;
import big.domain.MyClass100;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass100Service 
{

	public List<MyClass100> findAll () ;
	public List<MyClass100> findByCriteria (MyClass100Criteria criteria) ;
	public MyClass100 findById (Long id) ;
	public MyClass100 save (MyClass100 myclass100) ;

}
