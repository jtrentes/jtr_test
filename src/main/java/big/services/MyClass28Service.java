package big.services;

import java.util.List;
import big.repositories.criteria.MyClass28Criteria;
import big.domain.MyClass28;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass28Service 
{

	public List<MyClass28> findAll () ;
	public List<MyClass28> findByCriteria (MyClass28Criteria criteria) ;
	public MyClass28 findById (Long id) ;
	public MyClass28 save (MyClass28 myclass28) ;

}
