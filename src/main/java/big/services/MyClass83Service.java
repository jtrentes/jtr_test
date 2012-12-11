package big.services;

import java.util.List;
import big.repositories.criteria.MyClass83Criteria;
import big.domain.MyClass83;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass83Service 
{

	public List<MyClass83> findAll () ;
	public List<MyClass83> findByCriteria (MyClass83Criteria criteria) ;
	public MyClass83 findById (Long id) ;
	public MyClass83 save (MyClass83 myclass83) ;

}
