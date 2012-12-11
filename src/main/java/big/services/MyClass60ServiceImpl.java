package big.services;

import big.repositories.criteria.MyClass60Criteria;
import java.util.List;
import big.repositories.MyClass60Repository;
import big.domain.MyClass60;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass60Service")
@Transactional(readOnly = true)
public class MyClass60ServiceImpl implements MyClass60Service
{

	
	@Autowired
	private MyClass60Repository myClass60Repository;
    

	
	public List<MyClass60> findAll () 
	{
		return this.myClass60Repository.findAll();	
	}

	
	public List<MyClass60> findByCriteria (MyClass60Criteria criteria) 
	{
		return this.myClass60Repository.findByCriteria (criteria);	
	}

	
	public MyClass60 findById (Long id) 
	{
		return this.myClass60Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass60 save (MyClass60 myclass60) 
	{
		return this.myClass60Repository.save (myclass60);	
	}


}
