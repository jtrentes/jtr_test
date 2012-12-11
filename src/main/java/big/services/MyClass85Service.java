package big.services;

import big.domain.MyClass85;
import big.repositories.criteria.MyClass85Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass85Service 
{

	public List<MyClass85> findAll () ;
	public List<MyClass85> findByCriteria (MyClass85Criteria criteria) ;
	public MyClass85 findById (Long id) ;
	public MyClass85 save (MyClass85 myclass85) ;

}
