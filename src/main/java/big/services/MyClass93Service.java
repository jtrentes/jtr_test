package big.services;

import java.util.List;
import big.repositories.criteria.MyClass93Criteria;
import big.domain.MyClass93;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass93Service 
{

	public List<MyClass93> findAll () ;
	public List<MyClass93> findByCriteria (MyClass93Criteria criteria) ;
	public MyClass93 findById (Long id) ;
	public MyClass93 save (MyClass93 myclass93) ;

}
