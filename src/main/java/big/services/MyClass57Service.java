package big.services;

import big.repositories.criteria.MyClass57Criteria;
import big.domain.MyClass57;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass57Service 
{

	public List<MyClass57> findAll () ;
	public List<MyClass57> findByCriteria (MyClass57Criteria criteria) ;
	public MyClass57 findById (Long id) ;
	public MyClass57 save (MyClass57 myclass57) ;

}
