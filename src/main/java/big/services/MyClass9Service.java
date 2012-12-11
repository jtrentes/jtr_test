package big.services;

import big.domain.MyClass9;
import big.repositories.criteria.MyClass9Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass9Service 
{

	public List<MyClass9> findAll () ;
	public List<MyClass9> findByCriteria (MyClass9Criteria criteria) ;
	public MyClass9 findById (Long id) ;
	public MyClass9 save (MyClass9 myclass9) ;

}
