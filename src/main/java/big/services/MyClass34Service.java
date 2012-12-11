package big.services;

import big.repositories.criteria.MyClass34Criteria;
import java.util.List;
import big.domain.MyClass34;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass34Service 
{

	public List<MyClass34> findAll () ;
	public List<MyClass34> findByCriteria (MyClass34Criteria criteria) ;
	public MyClass34 findById (Long id) ;
	public MyClass34 save (MyClass34 myclass34) ;

}
