package big.repositories;

import big.repositories.criteria.MyClass130Criteria;
import java.util.List;
import big.domain.MyClass130;



public interface MyClass130Repository 
{

	public List<MyClass130> findAll () ;
	public List<MyClass130> findByCriteria (MyClass130Criteria myClass130Criteria) ;
	public MyClass130 findById (Long id) ;
	public MyClass130 save (MyClass130 myclass130) ;

}
