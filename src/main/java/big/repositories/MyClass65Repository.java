package big.repositories;

import big.domain.MyClass65;
import big.repositories.criteria.MyClass65Criteria;
import java.util.List;



public interface MyClass65Repository 
{

	public List<MyClass65> findAll () ;
	public List<MyClass65> findByCriteria (MyClass65Criteria myClass65Criteria) ;
	public MyClass65 findById (Long id) ;
	public MyClass65 save (MyClass65 myclass65) ;

}
