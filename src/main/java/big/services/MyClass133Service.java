package big.services;

import big.domain.MyClass133;
import java.util.List;
import big.repositories.criteria.MyClass133Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass133Service 
{

	public List<MyClass133> findAll () ;
	public List<MyClass133> findByCriteria (MyClass133Criteria criteria) ;
	public MyClass133 findById (Long id) ;
	public MyClass133 save (MyClass133 myclass133) ;

}
