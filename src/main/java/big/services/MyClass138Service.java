package big.services;

import java.util.List;
import big.domain.MyClass138;
import big.repositories.criteria.MyClass138Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass138Service 
{

	public List<MyClass138> findAll () ;
	public List<MyClass138> findByCriteria (MyClass138Criteria criteria) ;
	public MyClass138 findById (Long id) ;
	public MyClass138 save (MyClass138 myclass138) ;

}
