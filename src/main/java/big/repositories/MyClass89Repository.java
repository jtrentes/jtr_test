package big.repositories;

import java.util.List;
import big.repositories.criteria.MyClass89Criteria;
import big.domain.MyClass89;



public interface MyClass89Repository 
{

	public List<MyClass89> findAll () ;
	public List<MyClass89> findByCriteria (MyClass89Criteria myClass89Criteria) ;
	public MyClass89 findById (Long id) ;
	public MyClass89 save (MyClass89 myclass89) ;

}
