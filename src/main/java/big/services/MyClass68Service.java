package big.services;

import big.domain.MyClass68;
import java.util.List;
import big.repositories.criteria.MyClass68Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass68Service 
{

	public List<MyClass68> findAll () ;
	public List<MyClass68> findByCriteria (MyClass68Criteria criteria) ;
	public MyClass68 findById (Long id) ;
	public MyClass68 save (MyClass68 myclass68) ;

}
