package big.services;

import big.repositories.criteria.MyClass128Criteria;
import big.domain.MyClass128;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass128Service 
{

	public List<MyClass128> findAll () ;
	public List<MyClass128> findByCriteria (MyClass128Criteria criteria) ;
	public MyClass128 findById (Long id) ;
	public MyClass128 save (MyClass128 myclass128) ;

}
