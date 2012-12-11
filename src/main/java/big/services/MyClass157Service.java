package big.services;

import big.repositories.criteria.MyClass157Criteria;
import big.domain.MyClass157;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass157Service 
{

	public List<MyClass157> findAll () ;
	public List<MyClass157> findByCriteria (MyClass157Criteria criteria) ;
	public MyClass157 findById (Long id) ;
	public MyClass157 save (MyClass157 myclass157) ;

}
