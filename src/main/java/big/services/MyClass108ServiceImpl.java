package big.services;

import big.domain.MyClass108;
import big.repositories.MyClass108Repository;
import java.util.List;
import big.repositories.criteria.MyClass108Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass108Service")
@Transactional(readOnly = true)
public class MyClass108ServiceImpl implements MyClass108Service
{

	
	@Autowired
	private MyClass108Repository myClass108Repository;
    

	
	public List<MyClass108> findAll () 
	{
		return this.myClass108Repository.findAll();	
	}

	
	public List<MyClass108> findByCriteria (MyClass108Criteria criteria) 
	{
		return this.myClass108Repository.findByCriteria (criteria);	
	}

	
	public MyClass108 findById (Long id) 
	{
		return this.myClass108Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass108 save (MyClass108 myclass108) 
	{
		return this.myClass108Repository.save (myclass108);	
	}


}
