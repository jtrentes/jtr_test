package big.services;

import big.domain.MyClass67;
import java.util.List;
import big.repositories.MyClass67Repository;
import big.repositories.criteria.MyClass67Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass67Service")
@Transactional(readOnly = true)
public class MyClass67ServiceImpl implements MyClass67Service
{

	
	@Autowired
	private MyClass67Repository myClass67Repository;
    

	
	public List<MyClass67> findAll () 
	{
		return this.myClass67Repository.findAll();	
	}

	
	public List<MyClass67> findByCriteria (MyClass67Criteria criteria) 
	{
		return this.myClass67Repository.findByCriteria (criteria);	
	}

	
	public MyClass67 findById (Long id) 
	{
		return this.myClass67Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass67 save (MyClass67 myclass67) 
	{
		return this.myClass67Repository.save (myclass67);	
	}


}
