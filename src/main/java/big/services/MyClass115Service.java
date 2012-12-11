package big.services;

import java.util.List;
import big.repositories.criteria.MyClass115Criteria;
import big.domain.MyClass115;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass115Service 
{

	public List<MyClass115> findAll () ;
	public List<MyClass115> findByCriteria (MyClass115Criteria criteria) ;
	public MyClass115 findById (Long id) ;
	public MyClass115 save (MyClass115 myclass115) ;

}
