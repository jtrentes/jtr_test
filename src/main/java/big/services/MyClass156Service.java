package big.services;

import java.util.List;
import big.repositories.criteria.MyClass156Criteria;
import big.domain.MyClass156;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass156Service 
{

	public List<MyClass156> findAll () ;
	public List<MyClass156> findByCriteria (MyClass156Criteria criteria) ;
	public MyClass156 findById (Long id) ;
	public MyClass156 save (MyClass156 myclass156) ;

}
