package big.services;

import big.domain.MyClass112;
import java.util.List;
import big.repositories.criteria.MyClass112Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass112Service 
{

	public List<MyClass112> findAll () ;
	public List<MyClass112> findByCriteria (MyClass112Criteria criteria) ;
	public MyClass112 findById (Long id) ;
	public MyClass112 save (MyClass112 myclass112) ;

}
