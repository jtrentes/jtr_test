package big.services;

import big.repositories.criteria.MyClass27Criteria;
import big.repositories.MyClass27Repository;
import java.util.List;
import big.domain.MyClass27;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass27Service")
@Transactional(readOnly = true)
public class MyClass27ServiceImpl implements MyClass27Service
{

	
	@Autowired
	private MyClass27Repository myClass27Repository;
    

	
	public List<MyClass27> findAll () 
	{
		return this.myClass27Repository.findAll();	
	}

	
	public List<MyClass27> findByCriteria (MyClass27Criteria criteria) 
	{
		return this.myClass27Repository.findByCriteria (criteria);	
	}

	
	public MyClass27 findById (Long id) 
	{
		return this.myClass27Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass27 save (MyClass27 myclass27) 
	{
		return this.myClass27Repository.save (myclass27);	
	}


}
