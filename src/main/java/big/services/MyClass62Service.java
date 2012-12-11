package big.services;

import big.domain.MyClass62;
import big.repositories.criteria.MyClass62Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass62Service 
{

	public List<MyClass62> findAll () ;
	public List<MyClass62> findByCriteria (MyClass62Criteria criteria) ;
	public MyClass62 findById (Long id) ;
	public MyClass62 save (MyClass62 myclass62) ;

}
