package big.services;

import big.repositories.criteria.MyClass145Criteria;
import big.domain.MyClass145;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass145Service 
{

	public List<MyClass145> findAll () ;
	public List<MyClass145> findByCriteria (MyClass145Criteria criteria) ;
	public MyClass145 findById (Long id) ;
	public MyClass145 save (MyClass145 myclass145) ;

}
