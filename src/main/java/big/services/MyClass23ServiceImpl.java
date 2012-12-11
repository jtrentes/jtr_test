package big.services;

import java.util.List;
import big.repositories.MyClass23Repository;
import big.domain.MyClass23;
import big.repositories.criteria.MyClass23Criteria;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass23Service")
@Transactional(readOnly = true)
public class MyClass23ServiceImpl implements MyClass23Service
{

	
	@Autowired
	private MyClass23Repository myClass23Repository;
    

	
	public List<MyClass23> findAll () 
	{
		return this.myClass23Repository.findAll();	
	}

	
	public List<MyClass23> findByCriteria (MyClass23Criteria criteria) 
	{
		return this.myClass23Repository.findByCriteria (criteria);	
	}

	
	public MyClass23 findById (Long id) 
	{
		return this.myClass23Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass23 save (MyClass23 myclass23) 
	{
		return this.myClass23Repository.save (myclass23);	
	}


}
