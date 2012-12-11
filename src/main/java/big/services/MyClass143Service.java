package big.services;

import big.repositories.criteria.MyClass143Criteria;
import java.util.List;
import big.domain.MyClass143;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass143Service 
{

	public List<MyClass143> findAll () ;
	public List<MyClass143> findByCriteria (MyClass143Criteria criteria) ;
	public MyClass143 findById (Long id) ;
	public MyClass143 save (MyClass143 myclass143) ;

}
