package big.services;

import java.util.List;
import big.repositories.MyClass75Repository;
import big.repositories.criteria.MyClass75Criteria;
import big.domain.MyClass75;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass75Service")
@Transactional(readOnly = true)
public class MyClass75ServiceImpl implements MyClass75Service
{

	
	@Autowired
	private MyClass75Repository myClass75Repository;
    

	
	public List<MyClass75> findAll () 
	{
		return this.myClass75Repository.findAll();	
	}

	
	public List<MyClass75> findByCriteria (MyClass75Criteria criteria) 
	{
		return this.myClass75Repository.findByCriteria (criteria);	
	}

	
	public MyClass75 findById (Long id) 
	{
		return this.myClass75Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass75 save (MyClass75 myclass75) 
	{
		return this.myClass75Repository.save (myclass75);	
	}


}
