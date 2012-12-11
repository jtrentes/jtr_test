package big.services;

import big.repositories.criteria.MyClass154Criteria;
import big.domain.MyClass154;
import big.repositories.MyClass154Repository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass154Service")
@Transactional(readOnly = true)
public class MyClass154ServiceImpl implements MyClass154Service
{

	
	@Autowired
	private MyClass154Repository myClass154Repository;
    

	
	public List<MyClass154> findAll () 
	{
		return this.myClass154Repository.findAll();	
	}

	
	public List<MyClass154> findByCriteria (MyClass154Criteria criteria) 
	{
		return this.myClass154Repository.findByCriteria (criteria);	
	}

	
	public MyClass154 findById (Long id) 
	{
		return this.myClass154Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass154 save (MyClass154 myclass154) 
	{
		return this.myClass154Repository.save (myclass154);	
	}


}
