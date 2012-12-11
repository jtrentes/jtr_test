package big.services;

import java.util.List;
import big.domain.MyClass2;
import big.repositories.criteria.MyClass2Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass2Service 
{

	public List<MyClass2> findAll () ;
	public List<MyClass2> findByCriteria (MyClass2Criteria criteria) ;
	public MyClass2 findById (Long id) ;
	public MyClass2 save (MyClass2 myclass2) ;

}
