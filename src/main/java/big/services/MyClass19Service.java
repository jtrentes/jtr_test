package big.services;

import big.repositories.criteria.MyClass19Criteria;
import java.util.List;
import big.domain.MyClass19;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass19Service 
{

	public List<MyClass19> findAll () ;
	public List<MyClass19> findByCriteria (MyClass19Criteria criteria) ;
	public MyClass19 findById (Long id) ;
	public MyClass19 save (MyClass19 myclass19) ;

}
