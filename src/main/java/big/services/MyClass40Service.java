package big.services;

import big.repositories.criteria.MyClass40Criteria;
import java.util.List;
import big.domain.MyClass40;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass40Service 
{

	public List<MyClass40> findAll () ;
	public List<MyClass40> findByCriteria (MyClass40Criteria criteria) ;
	public MyClass40 findById (Long id) ;
	public MyClass40 save (MyClass40 myclass40) ;

}
