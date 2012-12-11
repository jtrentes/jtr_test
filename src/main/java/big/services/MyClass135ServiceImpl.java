package big.services;

import big.repositories.criteria.MyClass135Criteria;
import java.util.List;
import big.repositories.MyClass135Repository;
import big.domain.MyClass135;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass135Service")
@Transactional(readOnly = true)
public class MyClass135ServiceImpl implements MyClass135Service
{

	
	@Autowired
	private MyClass135Repository myClass135Repository;
    

	
	public List<MyClass135> findAll () 
	{
		return this.myClass135Repository.findAll();	
	}

	
	public List<MyClass135> findByCriteria (MyClass135Criteria criteria) 
	{
		return this.myClass135Repository.findByCriteria (criteria);	
	}

	
	public MyClass135 findById (Long id) 
	{
		return this.myClass135Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass135 save (MyClass135 myclass135) 
	{
		return this.myClass135Repository.save (myclass135);	
	}


}
