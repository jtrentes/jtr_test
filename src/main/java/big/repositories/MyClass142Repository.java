package big.repositories;

import big.repositories.criteria.MyClass142Criteria;
import big.domain.MyClass142;
import java.util.List;



public interface MyClass142Repository 
{

	public List<MyClass142> findAll () ;
	public List<MyClass142> findByCriteria (MyClass142Criteria myClass142Criteria) ;
	public MyClass142 findById (Long id) ;
	public MyClass142 save (MyClass142 myclass142) ;

}
