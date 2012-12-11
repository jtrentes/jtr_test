package big.services;

import big.domain.MyClass125;
import java.util.List;
import big.repositories.criteria.MyClass125Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass125Service 
{

	public List<MyClass125> findAll () ;
	public List<MyClass125> findByCriteria (MyClass125Criteria criteria) ;
	public MyClass125 findById (Long id) ;
	public MyClass125 save (MyClass125 myclass125) ;

}
