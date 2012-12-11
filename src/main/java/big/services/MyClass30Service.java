package big.services;

import big.repositories.criteria.MyClass30Criteria;
import java.util.List;
import big.domain.MyClass30;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass30Service 
{

	public List<MyClass30> findAll () ;
	public List<MyClass30> findByCriteria (MyClass30Criteria criteria) ;
	public MyClass30 findById (Long id) ;
	public MyClass30 save (MyClass30 myclass30) ;

}
