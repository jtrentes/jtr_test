package big.services;

import big.repositories.criteria.MyClass141Criteria;
import java.util.List;
import big.domain.MyClass141;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass141Service 
{

	public List<MyClass141> findAll () ;
	public List<MyClass141> findByCriteria (MyClass141Criteria criteria) ;
	public MyClass141 findById (Long id) ;
	public MyClass141 save (MyClass141 myclass141) ;

}
