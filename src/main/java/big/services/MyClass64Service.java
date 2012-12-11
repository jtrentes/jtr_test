package big.services;

import big.domain.MyClass64;
import big.repositories.criteria.MyClass64Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass64Service 
{

	public List<MyClass64> findAll () ;
	public List<MyClass64> findByCriteria (MyClass64Criteria criteria) ;
	public MyClass64 findById (Long id) ;
	public MyClass64 save (MyClass64 myclass64) ;

}
