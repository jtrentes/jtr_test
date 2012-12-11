package big.services;

import big.domain.MyClass107;
import big.repositories.criteria.MyClass107Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass107Service 
{

	public List<MyClass107> findAll () ;
	public List<MyClass107> findByCriteria (MyClass107Criteria criteria) ;
	public MyClass107 findById (Long id) ;
	public MyClass107 save (MyClass107 myclass107) ;

}
