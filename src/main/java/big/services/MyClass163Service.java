package big.services;

import big.repositories.criteria.MyClass163Criteria;
import big.domain.MyClass163;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass163Service 
{

	public List<MyClass163> findAll () ;
	public List<MyClass163> findByCriteria (MyClass163Criteria criteria) ;
	public MyClass163 findById (Long id) ;
	public MyClass163 save (MyClass163 myclass163) ;

}
