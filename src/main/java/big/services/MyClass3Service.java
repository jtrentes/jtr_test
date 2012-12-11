package big.services;

import java.util.List;
import big.repositories.criteria.MyClass3Criteria;
import big.domain.MyClass3;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass3Service 
{

	public List<MyClass3> findAll () ;
	public List<MyClass3> findByCriteria (MyClass3Criteria criteria) ;
	public MyClass3 findById (Long id) ;
	public MyClass3 save (MyClass3 myclass3) ;

}
