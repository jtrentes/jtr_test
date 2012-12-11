package big.services;

import big.domain.MyClass60;
import big.repositories.criteria.MyClass60Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass60Service 
{

	public List<MyClass60> findAll () ;
	public List<MyClass60> findByCriteria (MyClass60Criteria criteria) ;
	public MyClass60 findById (Long id) ;
	public MyClass60 save (MyClass60 myclass60) ;

}
