package big.services;

import java.util.List;
import big.repositories.criteria.MyClass76Criteria;
import big.domain.MyClass76;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass76Service 
{

	public List<MyClass76> findAll () ;
	public List<MyClass76> findByCriteria (MyClass76Criteria criteria) ;
	public MyClass76 findById (Long id) ;
	public MyClass76 save (MyClass76 myclass76) ;

}
