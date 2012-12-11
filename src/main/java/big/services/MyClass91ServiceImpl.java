package big.services;

import big.repositories.MyClass91Repository;
import big.repositories.criteria.MyClass91Criteria;
import big.domain.MyClass91;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass91Service")
@Transactional(readOnly = true)
public class MyClass91ServiceImpl implements MyClass91Service
{

	
	@Autowired
	private MyClass91Repository myClass91Repository;
    

	
	public List<MyClass91> findAll () 
	{
		return this.myClass91Repository.findAll();	
	}

	
	public List<MyClass91> findByCriteria (MyClass91Criteria criteria) 
	{
		return this.myClass91Repository.findByCriteria (criteria);	
	}

	
	public MyClass91 findById (Long id) 
	{
		return this.myClass91Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass91 save (MyClass91 myclass91) 
	{
		return this.myClass91Repository.save (myclass91);	
	}


}
