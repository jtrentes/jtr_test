package big.services;

import big.repositories.criteria.MyClass55Criteria;
import big.domain.MyClass55;
import big.repositories.MyClass55Repository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass55Service")
@Transactional(readOnly = true)
public class MyClass55ServiceImpl implements MyClass55Service
{

	
	@Autowired
	private MyClass55Repository myClass55Repository;
    

	
	public List<MyClass55> findAll () 
	{
		return this.myClass55Repository.findAll();	
	}

	
	public List<MyClass55> findByCriteria (MyClass55Criteria criteria) 
	{
		return this.myClass55Repository.findByCriteria (criteria);	
	}

	
	public MyClass55 findById (Long id) 
	{
		return this.myClass55Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass55 save (MyClass55 myclass55) 
	{
		return this.myClass55Repository.save (myclass55);	
	}


}
