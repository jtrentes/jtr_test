package big.services;

import java.util.List;
import big.repositories.criteria.MyClass144Criteria;
import big.repositories.MyClass144Repository;
import big.domain.MyClass144;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass144Service")
@Transactional(readOnly = true)
public class MyClass144ServiceImpl implements MyClass144Service
{

	
	@Autowired
	private MyClass144Repository myClass144Repository;
    

	
	public List<MyClass144> findAll () 
	{
		return this.myClass144Repository.findAll();	
	}

	
	public List<MyClass144> findByCriteria (MyClass144Criteria criteria) 
	{
		return this.myClass144Repository.findByCriteria (criteria);	
	}

	
	public MyClass144 findById (Long id) 
	{
		return this.myClass144Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass144 save (MyClass144 myclass144) 
	{
		return this.myClass144Repository.save (myclass144);	
	}


}
