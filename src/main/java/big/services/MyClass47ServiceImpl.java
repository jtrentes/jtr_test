package big.services;

import big.repositories.criteria.MyClass47Criteria;
import big.domain.MyClass47;
import big.repositories.MyClass47Repository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass47Service")
@Transactional(readOnly = true)
public class MyClass47ServiceImpl implements MyClass47Service
{

	
	@Autowired
	private MyClass47Repository myClass47Repository;
    

	
	public List<MyClass47> findAll () 
	{
		return this.myClass47Repository.findAll();	
	}

	
	public List<MyClass47> findByCriteria (MyClass47Criteria criteria) 
	{
		return this.myClass47Repository.findByCriteria (criteria);	
	}

	
	public MyClass47 findById (Long id) 
	{
		return this.myClass47Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass47 save (MyClass47 myclass47) 
	{
		return this.myClass47Repository.save (myclass47);	
	}


}
