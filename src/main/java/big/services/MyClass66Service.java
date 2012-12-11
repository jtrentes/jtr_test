package big.services;

import java.util.List;
import big.domain.MyClass66;
import big.repositories.criteria.MyClass66Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass66Service 
{

	public List<MyClass66> findAll () ;
	public List<MyClass66> findByCriteria (MyClass66Criteria criteria) ;
	public MyClass66 findById (Long id) ;
	public MyClass66 save (MyClass66 myclass66) ;

}
