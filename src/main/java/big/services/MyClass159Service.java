package big.services;

import big.domain.MyClass159;
import java.util.List;
import big.repositories.criteria.MyClass159Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass159Service 
{

	public List<MyClass159> findAll () ;
	public List<MyClass159> findByCriteria (MyClass159Criteria criteria) ;
	public MyClass159 findById (Long id) ;
	public MyClass159 save (MyClass159 myclass159) ;

}
