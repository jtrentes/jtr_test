package big.services;

import big.repositories.MyClass15Repository;
import big.domain.MyClass15;
import big.repositories.criteria.MyClass15Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass15Service")
@Transactional(readOnly = true)
public class MyClass15ServiceImpl implements MyClass15Service
{

	
	@Autowired
	private MyClass15Repository myClass15Repository;
    

	
	public List<MyClass15> findAll () 
	{
		return this.myClass15Repository.findAll();	
	}

	
	public List<MyClass15> findByCriteria (MyClass15Criteria criteria) 
	{
		return this.myClass15Repository.findByCriteria (criteria);	
	}

	
	public MyClass15 findById (Long id) 
	{
		return this.myClass15Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass15 save (MyClass15 myclass15) 
	{
		return this.myClass15Repository.save (myclass15);	
	}


}
