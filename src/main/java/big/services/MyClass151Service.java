package big.services;

import big.domain.MyClass151;
import big.repositories.criteria.MyClass151Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass151Service 
{

	public List<MyClass151> findAll () ;
	public List<MyClass151> findByCriteria (MyClass151Criteria criteria) ;
	public MyClass151 findById (Long id) ;
	public MyClass151 save (MyClass151 myclass151) ;

}
