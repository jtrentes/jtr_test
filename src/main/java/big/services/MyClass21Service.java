package big.services;

import java.util.List;
import big.repositories.criteria.MyClass21Criteria;
import big.domain.MyClass21;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass21Service 
{

	public List<MyClass21> findAll () ;
	public List<MyClass21> findByCriteria (MyClass21Criteria criteria) ;
	public MyClass21 findById (Long id) ;
	public MyClass21 save (MyClass21 myclass21) ;

}
