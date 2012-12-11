package big.services;

import java.util.List;
import big.repositories.criteria.MyClass50Criteria;
import big.domain.MyClass50;
import big.repositories.MyClass50Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass50Service")
@Transactional(readOnly = true)
public class MyClass50ServiceImpl implements MyClass50Service
{

	
	@Autowired
	private MyClass50Repository myClass50Repository;
    

	
	public List<MyClass50> findAll () 
	{
		return this.myClass50Repository.findAll();	
	}

	
	public List<MyClass50> findByCriteria (MyClass50Criteria criteria) 
	{
		return this.myClass50Repository.findByCriteria (criteria);	
	}

	
	public MyClass50 findById (Long id) 
	{
		return this.myClass50Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass50 save (MyClass50 myclass50) 
	{
		return this.myClass50Repository.save (myclass50);	
	}


}
