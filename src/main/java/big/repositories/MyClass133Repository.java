package big.repositories;

import java.util.List;
import big.domain.MyClass133;
import big.repositories.criteria.MyClass133Criteria;



public interface MyClass133Repository 
{

	public List<MyClass133> findAll () ;
	public List<MyClass133> findByCriteria (MyClass133Criteria myClass133Criteria) ;
	public MyClass133 findById (Long id) ;
	public MyClass133 save (MyClass133 myclass133) ;

}
