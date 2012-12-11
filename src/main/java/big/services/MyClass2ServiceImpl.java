package big.services;

import big.repositories.criteria.MyClass2Criteria;
import big.domain.MyClass2;
import big.repositories.MyClass2Repository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass2Service")
@Transactional(readOnly = true)
public class MyClass2ServiceImpl implements MyClass2Service
{

	
	@Autowired
	private MyClass2Repository myClass2Repository;
    

	
	public List<MyClass2> findAll () 
	{
		return this.myClass2Repository.findAll();	
	}

	
	public List<MyClass2> findByCriteria (MyClass2Criteria criteria) 
	{
		return this.myClass2Repository.findByCriteria (criteria);	
	}

	
	public MyClass2 findById (Long id) 
	{
		return this.myClass2Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass2 save (MyClass2 myclass2) 
	{
		return this.myClass2Repository.save (myclass2);	
	}


}
