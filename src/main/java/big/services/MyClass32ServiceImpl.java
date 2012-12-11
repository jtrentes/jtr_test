package big.services;

import big.repositories.criteria.MyClass32Criteria;
import big.repositories.MyClass32Repository;
import java.util.List;
import big.domain.MyClass32;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass32Service")
@Transactional(readOnly = true)
public class MyClass32ServiceImpl implements MyClass32Service
{

	
	@Autowired
	private MyClass32Repository myClass32Repository;
    

	
	public List<MyClass32> findAll () 
	{
		return this.myClass32Repository.findAll();	
	}

	
	public List<MyClass32> findByCriteria (MyClass32Criteria criteria) 
	{
		return this.myClass32Repository.findByCriteria (criteria);	
	}

	
	public MyClass32 findById (Long id) 
	{
		return this.myClass32Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass32 save (MyClass32 myclass32) 
	{
		return this.myClass32Repository.save (myclass32);	
	}


}
