package big.services;

import big.domain.MyClass160;
import java.util.List;
import big.repositories.criteria.MyClass160Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass160Service 
{

	public List<MyClass160> findAll () ;
	public List<MyClass160> findByCriteria (MyClass160Criteria criteria) ;
	public MyClass160 findById (Long id) ;
	public MyClass160 save (MyClass160 myclass160) ;

}
