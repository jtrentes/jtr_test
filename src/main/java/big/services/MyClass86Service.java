package big.services;

import java.util.List;
import big.repositories.criteria.MyClass86Criteria;
import big.domain.MyClass86;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass86Service 
{

	public List<MyClass86> findAll () ;
	public List<MyClass86> findByCriteria (MyClass86Criteria criteria) ;
	public MyClass86 findById (Long id) ;
	public MyClass86 save (MyClass86 myclass86) ;

}
