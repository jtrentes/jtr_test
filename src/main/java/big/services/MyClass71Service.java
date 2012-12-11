package big.services;

import big.repositories.criteria.MyClass71Criteria;
import java.util.List;
import big.domain.MyClass71;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass71Service 
{

	public List<MyClass71> findAll () ;
	public List<MyClass71> findByCriteria (MyClass71Criteria criteria) ;
	public MyClass71 findById (Long id) ;
	public MyClass71 save (MyClass71 myclass71) ;

}
