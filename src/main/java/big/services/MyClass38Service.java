package big.services;

import big.repositories.criteria.MyClass38Criteria;
import java.util.List;
import big.domain.MyClass38;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass38Service 
{

	public List<MyClass38> findAll () ;
	public List<MyClass38> findByCriteria (MyClass38Criteria criteria) ;
	public MyClass38 findById (Long id) ;
	public MyClass38 save (MyClass38 myclass38) ;

}
