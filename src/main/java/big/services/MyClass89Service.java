package big.services;

import big.repositories.criteria.MyClass89Criteria;
import big.domain.MyClass89;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass89Service 
{

	public List<MyClass89> findAll () ;
	public List<MyClass89> findByCriteria (MyClass89Criteria criteria) ;
	public MyClass89 findById (Long id) ;
	public MyClass89 save (MyClass89 myclass89) ;

}
