package big.services;

import big.domain.MyClass41;
import java.util.List;
import big.repositories.criteria.MyClass41Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass41Service 
{

	public List<MyClass41> findAll () ;
	public List<MyClass41> findByCriteria (MyClass41Criteria criteria) ;
	public MyClass41 findById (Long id) ;
	public MyClass41 save (MyClass41 myclass41) ;

}
