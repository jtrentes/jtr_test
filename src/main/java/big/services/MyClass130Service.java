package big.services;

import big.repositories.criteria.MyClass130Criteria;
import java.util.List;
import big.domain.MyClass130;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass130Service 
{

	public List<MyClass130> findAll () ;
	public List<MyClass130> findByCriteria (MyClass130Criteria criteria) ;
	public MyClass130 findById (Long id) ;
	public MyClass130 save (MyClass130 myclass130) ;

}
