package big.services;

import big.domain.MyClass16;
import big.repositories.criteria.MyClass16Criteria;
import big.repositories.MyClass16Repository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass16Service")
@Transactional(readOnly = true)
public class MyClass16ServiceImpl implements MyClass16Service
{

	
	@Autowired
	private MyClass16Repository myClass16Repository;
    

	
	public List<MyClass16> findAll () 
	{
		return this.myClass16Repository.findAll();	
	}

	
	public List<MyClass16> findByCriteria (MyClass16Criteria criteria) 
	{
		return this.myClass16Repository.findByCriteria (criteria);	
	}

	
	public MyClass16 findById (Long id) 
	{
		return this.myClass16Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass16 save (MyClass16 myclass16) 
	{
		return this.myClass16Repository.save (myclass16);	
	}


}
