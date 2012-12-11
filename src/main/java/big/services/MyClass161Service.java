package big.services;

import big.domain.MyClass161;
import java.util.List;
import big.repositories.criteria.MyClass161Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass161Service 
{

	public List<MyClass161> findAll () ;
	public List<MyClass161> findByCriteria (MyClass161Criteria criteria) ;
	public MyClass161 findById (Long id) ;
	public MyClass161 save (MyClass161 myclass161) ;

}
