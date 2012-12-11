package big.services;

import big.repositories.criteria.MyClass131Criteria;
import java.util.List;
import big.domain.MyClass131;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass131Service 
{

	public List<MyClass131> findAll () ;
	public List<MyClass131> findByCriteria (MyClass131Criteria criteria) ;
	public MyClass131 findById (Long id) ;
	public MyClass131 save (MyClass131 myclass131) ;

}
