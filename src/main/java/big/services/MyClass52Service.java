package big.services;

import big.domain.MyClass52;
import java.util.List;
import big.repositories.criteria.MyClass52Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass52Service 
{

	public List<MyClass52> findAll () ;
	public List<MyClass52> findByCriteria (MyClass52Criteria criteria) ;
	public MyClass52 findById (Long id) ;
	public MyClass52 save (MyClass52 myclass52) ;

}
