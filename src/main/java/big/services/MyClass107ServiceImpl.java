package big.services;

import big.repositories.MyClass107Repository;
import big.domain.MyClass107;
import java.util.List;
import big.repositories.criteria.MyClass107Criteria;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass107Service")
@Transactional(readOnly = true)
public class MyClass107ServiceImpl implements MyClass107Service
{

	
	@Autowired
	private MyClass107Repository myClass107Repository;
    

	
	public List<MyClass107> findAll () 
	{
		return this.myClass107Repository.findAll();	
	}

	
	public List<MyClass107> findByCriteria (MyClass107Criteria criteria) 
	{
		return this.myClass107Repository.findByCriteria (criteria);	
	}

	
	public MyClass107 findById (Long id) 
	{
		return this.myClass107Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass107 save (MyClass107 myclass107) 
	{
		return this.myClass107Repository.save (myclass107);	
	}


}
