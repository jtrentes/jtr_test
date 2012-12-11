package big.services;

import big.domain.MyClass162;
import big.repositories.criteria.MyClass162Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass162Service 
{

	public List<MyClass162> findAll () ;
	public List<MyClass162> findByCriteria (MyClass162Criteria criteria) ;
	public MyClass162 findById (Long id) ;
	public MyClass162 save (MyClass162 myclass162) ;

}
