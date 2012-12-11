package big.services;

import big.domain.MyClass150;
import java.util.List;
import big.repositories.criteria.MyClass150Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass150Service 
{

	public List<MyClass150> findAll () ;
	public List<MyClass150> findByCriteria (MyClass150Criteria criteria) ;
	public MyClass150 findById (Long id) ;
	public MyClass150 save (MyClass150 myclass150) ;

}
