package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass68Criteria;
import big.domain.MyClass68;



public interface MyClass68Repository 
{

	public List<MyClass68> findAll () ;
	public List<MyClass68> findByCriteria (MyClass68Criteria myClass68Criteria) ;
	public MyClass68 findById (Long id) ;
	public MyClass68 save (MyClass68 myclass68) ;

}
