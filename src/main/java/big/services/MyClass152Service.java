package big.services;

import big.repositories.criteria.MyClass152Criteria;
import java.util.List;
import big.domain.MyClass152;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass152Service 
{

	public List<MyClass152> findAll () ;
	public List<MyClass152> findByCriteria (MyClass152Criteria criteria) ;
	public MyClass152 findById (Long id) ;
	public MyClass152 save (MyClass152 myclass152) ;

}
