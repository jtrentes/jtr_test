package big.services;

import big.repositories.criteria.MyClass111Criteria;
import java.util.List;
import big.domain.MyClass111;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass111Service 
{

	public List<MyClass111> findAll () ;
	public List<MyClass111> findByCriteria (MyClass111Criteria criteria) ;
	public MyClass111 findById (Long id) ;
	public MyClass111 save (MyClass111 myclass111) ;

}
