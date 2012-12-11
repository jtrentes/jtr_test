package big.services;

import big.repositories.criteria.MyClass20Criteria;
import big.domain.MyClass20;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass20Service 
{

	public List<MyClass20> findAll () ;
	public List<MyClass20> findByCriteria (MyClass20Criteria criteria) ;
	public MyClass20 findById (Long id) ;
	public MyClass20 save (MyClass20 myclass20) ;

}
