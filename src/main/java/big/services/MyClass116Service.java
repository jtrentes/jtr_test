package big.services;

import big.domain.MyClass116;
import java.util.List;
import big.repositories.criteria.MyClass116Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass116Service 
{

	public List<MyClass116> findAll () ;
	public List<MyClass116> findByCriteria (MyClass116Criteria criteria) ;
	public MyClass116 findById (Long id) ;
	public MyClass116 save (MyClass116 myclass116) ;

}
