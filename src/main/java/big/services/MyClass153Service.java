package big.services;

import java.util.List;
import big.domain.MyClass153;
import big.repositories.criteria.MyClass153Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass153Service 
{

	public List<MyClass153> findAll () ;
	public List<MyClass153> findByCriteria (MyClass153Criteria criteria) ;
	public MyClass153 findById (Long id) ;
	public MyClass153 save (MyClass153 myclass153) ;

}
