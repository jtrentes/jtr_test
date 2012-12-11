package big.services;

import big.repositories.criteria.MyClass11Criteria;
import big.domain.MyClass11;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass11Service 
{

	public List<MyClass11> findAll () ;
	public List<MyClass11> findByCriteria (MyClass11Criteria criteria) ;
	public MyClass11 findById (Long id) ;
	public MyClass11 save (MyClass11 myclass11) ;

}
