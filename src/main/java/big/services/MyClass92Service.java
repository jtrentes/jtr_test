package big.services;

import big.repositories.criteria.MyClass92Criteria;
import java.util.List;
import big.domain.MyClass92;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass92Service 
{

	public List<MyClass92> findAll () ;
	public List<MyClass92> findByCriteria (MyClass92Criteria criteria) ;
	public MyClass92 findById (Long id) ;
	public MyClass92 save (MyClass92 myclass92) ;

}
