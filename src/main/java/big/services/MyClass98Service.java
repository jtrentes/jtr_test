package big.services;

import big.repositories.criteria.MyClass98Criteria;
import java.util.List;
import big.domain.MyClass98;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass98Service 
{

	public List<MyClass98> findAll () ;
	public List<MyClass98> findByCriteria (MyClass98Criteria criteria) ;
	public MyClass98 findById (Long id) ;
	public MyClass98 save (MyClass98 myclass98) ;

}
