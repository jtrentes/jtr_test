package big.services;

import big.domain.MyClass111;
import big.repositories.criteria.MyClass111Criteria;
import big.repositories.MyClass111Repository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass111Service")
@Transactional(readOnly = true)
public class MyClass111ServiceImpl implements MyClass111Service
{

	
	@Autowired
	private MyClass111Repository myClass111Repository;
    

	
	public List<MyClass111> findAll () 
	{
		return this.myClass111Repository.findAll();	
	}

	
	public List<MyClass111> findByCriteria (MyClass111Criteria criteria) 
	{
		return this.myClass111Repository.findByCriteria (criteria);	
	}

	
	public MyClass111 findById (Long id) 
	{
		return this.myClass111Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass111 save (MyClass111 myclass111) 
	{
		return this.myClass111Repository.save (myclass111);	
	}


}
