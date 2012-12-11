package big.services;

import java.util.List;
import big.domain.MyClass105;
import big.repositories.criteria.MyClass105Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass105Service 
{

	public List<MyClass105> findAll () ;
	public List<MyClass105> findByCriteria (MyClass105Criteria criteria) ;
	public MyClass105 findById (Long id) ;
	public MyClass105 save (MyClass105 myclass105) ;

}
