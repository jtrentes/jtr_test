package big.services;

import big.domain.MyClass137;
import java.util.List;
import big.repositories.criteria.MyClass137Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass137Service 
{

	public List<MyClass137> findAll () ;
	public List<MyClass137> findByCriteria (MyClass137Criteria criteria) ;
	public MyClass137 findById (Long id) ;
	public MyClass137 save (MyClass137 myclass137) ;

}
