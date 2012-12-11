package big.services;

import big.repositories.MyClass97Repository;
import java.util.List;
import big.repositories.criteria.MyClass97Criteria;
import big.domain.MyClass97;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass97Service")
@Transactional(readOnly = true)
public class MyClass97ServiceImpl implements MyClass97Service
{

	
	@Autowired
	private MyClass97Repository myClass97Repository;
    

	
	public List<MyClass97> findAll () 
	{
		return this.myClass97Repository.findAll();	
	}

	
	public List<MyClass97> findByCriteria (MyClass97Criteria criteria) 
	{
		return this.myClass97Repository.findByCriteria (criteria);	
	}

	
	public MyClass97 findById (Long id) 
	{
		return this.myClass97Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass97 save (MyClass97 myclass97) 
	{
		return this.myClass97Repository.save (myclass97);	
	}


}
