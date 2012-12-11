package big.services;

import big.repositories.criteria.MyClass87Criteria;
import big.domain.MyClass87;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass87Service 
{

	public List<MyClass87> findAll () ;
	public List<MyClass87> findByCriteria (MyClass87Criteria criteria) ;
	public MyClass87 findById (Long id) ;
	public MyClass87 save (MyClass87 myclass87) ;

}
