package big.services;

import java.util.List;
import big.repositories.MyClass120Repository;
import big.repositories.criteria.MyClass120Criteria;
import big.domain.MyClass120;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass120Service")
@Transactional(readOnly = true)
public class MyClass120ServiceImpl implements MyClass120Service
{

	
	@Autowired
	private MyClass120Repository myClass120Repository;
    

	
	public List<MyClass120> findAll () 
	{
		return this.myClass120Repository.findAll();	
	}

	
	public List<MyClass120> findByCriteria (MyClass120Criteria criteria) 
	{
		return this.myClass120Repository.findByCriteria (criteria);	
	}

	
	public MyClass120 findById (Long id) 
	{
		return this.myClass120Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass120 save (MyClass120 myclass120) 
	{
		return this.myClass120Repository.save (myclass120);	
	}


}
