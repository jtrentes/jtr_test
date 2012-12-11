package big.services;

import big.repositories.criteria.MyClass118Criteria;
import java.util.List;
import big.domain.MyClass118;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass118Service 
{

	public List<MyClass118> findAll () ;
	public List<MyClass118> findByCriteria (MyClass118Criteria criteria) ;
	public MyClass118 findById (Long id) ;
	public MyClass118 save (MyClass118 myclass118) ;

}
