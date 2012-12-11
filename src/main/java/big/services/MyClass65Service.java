package big.services;

import big.domain.MyClass65;
import java.util.List;
import big.repositories.criteria.MyClass65Criteria;
import org.springframework.transaction.annotation.Transactional;



public interface MyClass65Service 
{

	public List<MyClass65> findAll () ;
	public List<MyClass65> findByCriteria (MyClass65Criteria criteria) ;
	public MyClass65 findById (Long id) ;
	public MyClass65 save (MyClass65 myclass65) ;

}
