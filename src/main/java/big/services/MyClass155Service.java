package big.services;

import big.domain.MyClass155;
import java.util.List;
import big.repositories.criteria.MyClass155Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass155Service 
{

	public List<MyClass155> findAll () ;
	public List<MyClass155> findByCriteria (MyClass155Criteria criteria) ;
	public MyClass155 findById (Long id) ;
	public MyClass155 save (MyClass155 myclass155) ;

}
