package big.services;

import big.repositories.criteria.MyClass139Criteria;
import java.util.List;
import big.domain.MyClass139;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass139Service 
{

	public List<MyClass139> findAll () ;
	public List<MyClass139> findByCriteria (MyClass139Criteria criteria) ;
	public MyClass139 findById (Long id) ;
	public MyClass139 save (MyClass139 myclass139) ;

}
