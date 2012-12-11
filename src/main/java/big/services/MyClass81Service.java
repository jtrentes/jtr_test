package big.services;

import java.util.List;
import big.domain.MyClass81;
import big.repositories.criteria.MyClass81Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass81Service 
{

	public List<MyClass81> findAll () ;
	public List<MyClass81> findByCriteria (MyClass81Criteria criteria) ;
	public MyClass81 findById (Long id) ;
	public MyClass81 save (MyClass81 myclass81) ;

}
