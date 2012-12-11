package big.services;

import big.repositories.criteria.MyClass45Criteria;
import java.util.List;
import big.domain.MyClass45;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass45Service 
{

	public List<MyClass45> findAll () ;
	public List<MyClass45> findByCriteria (MyClass45Criteria criteria) ;
	public MyClass45 findById (Long id) ;
	public MyClass45 save (MyClass45 myclass45) ;

}
