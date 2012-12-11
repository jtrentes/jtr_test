package big.services;

import big.repositories.criteria.MyClass33Criteria;
import big.domain.MyClass33;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass33Service 
{

	public List<MyClass33> findAll () ;
	public List<MyClass33> findByCriteria (MyClass33Criteria criteria) ;
	public MyClass33 findById (Long id) ;
	public MyClass33 save (MyClass33 myclass33) ;

}
