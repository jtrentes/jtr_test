package big.services;

import big.repositories.criteria.MyClass39Criteria;
import big.domain.MyClass39;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass39Service 
{

	public List<MyClass39> findAll () ;
	public List<MyClass39> findByCriteria (MyClass39Criteria criteria) ;
	public MyClass39 findById (Long id) ;
	public MyClass39 save (MyClass39 myclass39) ;

}
