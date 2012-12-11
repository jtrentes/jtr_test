package big.services;

import big.repositories.criteria.MyClass142Criteria;
import java.util.List;
import big.domain.MyClass142;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass142Service 
{

	public List<MyClass142> findAll () ;
	public List<MyClass142> findByCriteria (MyClass142Criteria criteria) ;
	public MyClass142 findById (Long id) ;
	public MyClass142 save (MyClass142 myclass142) ;

}
