package big.repositories;

import big.domain.MyClass111;
import java.util.List;
import big.repositories.criteria.MyClass111Criteria;



public interface MyClass111Repository 
{

	public List<MyClass111> findAll () ;
	public List<MyClass111> findByCriteria (MyClass111Criteria myClass111Criteria) ;
	public MyClass111 findById (Long id) ;
	public MyClass111 save (MyClass111 myclass111) ;

}
