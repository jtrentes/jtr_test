package big.services;

import big.repositories.criteria.MyClass10Criteria;
import java.util.List;
import big.domain.MyClass10;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass10Service 
{

	public List<MyClass10> findAll () ;
	public List<MyClass10> findByCriteria (MyClass10Criteria criteria) ;
	public MyClass10 findById (Long id) ;
	public MyClass10 save (MyClass10 myclass10) ;

}
