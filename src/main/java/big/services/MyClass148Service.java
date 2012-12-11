package big.services;

import java.util.List;
import big.repositories.criteria.MyClass148Criteria;
import big.domain.MyClass148;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass148Service 
{

	public List<MyClass148> findAll () ;
	public List<MyClass148> findByCriteria (MyClass148Criteria criteria) ;
	public MyClass148 findById (Long id) ;
	public MyClass148 save (MyClass148 myclass148) ;

}
