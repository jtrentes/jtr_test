package big.services;

import big.domain.MyClass5;
import big.repositories.criteria.MyClass5Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass5Service 
{

	public List<MyClass5> findAll () ;
	public List<MyClass5> findByCriteria (MyClass5Criteria criteria) ;
	public MyClass5 findById (Long id) ;
	public MyClass5 save (MyClass5 myclass5) ;

}
