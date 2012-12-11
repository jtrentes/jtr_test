package big.services;

import big.repositories.criteria.MyClass102Criteria;
import big.domain.MyClass102;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass102Service 
{

	public List<MyClass102> findAll () ;
	public List<MyClass102> findByCriteria (MyClass102Criteria criteria) ;
	public MyClass102 findById (Long id) ;
	public MyClass102 save (MyClass102 myclass102) ;

}
