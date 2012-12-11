package big.services;

import big.domain.MyClass80;
import java.util.List;
import big.repositories.criteria.MyClass80Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass80Service 
{

	public List<MyClass80> findAll () ;
	public List<MyClass80> findByCriteria (MyClass80Criteria criteria) ;
	public MyClass80 findById (Long id) ;
	public MyClass80 save (MyClass80 myclass80) ;

}
