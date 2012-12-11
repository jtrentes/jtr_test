package big.services;

import big.domain.MyClass4;
import big.repositories.criteria.MyClass4Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass4Service 
{

	public List<MyClass4> findAll () ;
	public List<MyClass4> findByCriteria (MyClass4Criteria criteria) ;
	public MyClass4 findById (Long id) ;
	public MyClass4 save (MyClass4 myclass4) ;

}
