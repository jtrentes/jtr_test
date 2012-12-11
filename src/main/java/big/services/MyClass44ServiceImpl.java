package big.services;

import java.util.List;
import big.repositories.criteria.MyClass44Criteria;
import big.repositories.MyClass44Repository;
import big.domain.MyClass44;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass44Service")
@Transactional(readOnly = true)
public class MyClass44ServiceImpl implements MyClass44Service
{

	
	@Autowired
	private MyClass44Repository myClass44Repository;
    

	
	public List<MyClass44> findAll () 
	{
		return this.myClass44Repository.findAll();	
	}

	
	public List<MyClass44> findByCriteria (MyClass44Criteria criteria) 
	{
		return this.myClass44Repository.findByCriteria (criteria);	
	}

	
	public MyClass44 findById (Long id) 
	{
		return this.myClass44Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass44 save (MyClass44 myclass44) 
	{
		return this.myClass44Repository.save (myclass44);	
	}


}
