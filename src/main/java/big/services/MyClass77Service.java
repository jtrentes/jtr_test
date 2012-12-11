package big.services;

import big.domain.MyClass77;
import big.repositories.criteria.MyClass77Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass77Service 
{

	public List<MyClass77> findAll () ;
	public List<MyClass77> findByCriteria (MyClass77Criteria criteria) ;
	public MyClass77 findById (Long id) ;
	public MyClass77 save (MyClass77 myclass77) ;

}
