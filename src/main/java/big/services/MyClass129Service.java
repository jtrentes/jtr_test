package big.services;

import big.domain.MyClass129;
import big.repositories.criteria.MyClass129Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass129Service 
{

	public List<MyClass129> findAll () ;
	public List<MyClass129> findByCriteria (MyClass129Criteria criteria) ;
	public MyClass129 findById (Long id) ;
	public MyClass129 save (MyClass129 myclass129) ;

}
