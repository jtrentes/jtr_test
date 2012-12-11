package big.services;

import java.util.List;
import big.repositories.MyClass100Repository;
import big.repositories.criteria.MyClass100Criteria;
import big.domain.MyClass100;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass100Service")
@Transactional(readOnly = true)
public class MyClass100ServiceImpl implements MyClass100Service
{

	
	@Autowired
	private MyClass100Repository myClass100Repository;
    

	
	public List<MyClass100> findAll () 
	{
		return this.myClass100Repository.findAll();	
	}

	
	public List<MyClass100> findByCriteria (MyClass100Criteria criteria) 
	{
		return this.myClass100Repository.findByCriteria (criteria);	
	}

	
	public MyClass100 findById (Long id) 
	{
		return this.myClass100Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass100 save (MyClass100 myclass100) 
	{
		return this.myClass100Repository.save (myclass100);	
	}


}
