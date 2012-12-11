package big.services;

import big.domain.MyClass114;
import java.util.List;
import big.repositories.criteria.MyClass114Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass114Service 
{

	public List<MyClass114> findAll () ;
	public List<MyClass114> findByCriteria (MyClass114Criteria criteria) ;
	public MyClass114 findById (Long id) ;
	public MyClass114 save (MyClass114 myclass114) ;

}
